package fr.mai.ntiers.config.security;

import fr.mai.ntiers.SpringApplicationContext;
import fr.mai.ntiers.config.properties.SecurityProperties;
import fr.mai.ntiers.dto.CompteDto;
import fr.mai.ntiers.request.CompteConnexionRequestModel;
import fr.mai.ntiers.response.CompteConnexionResponseModel;
import fr.mai.ntiers.service.CompteService;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final SecurityProperties securityProperties;

  private final AuthenticationManager authenticationManager;

  public AuthenticationFilter(
    SecurityProperties securityProperties,
    AuthenticationManager authenticationManager
  ) {
    this.securityProperties = securityProperties;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws AuthenticationException {
    try {
      CompteConnexionRequestModel creds = new ObjectMapper().readValue(request.getInputStream(), CompteConnexionRequestModel.class);
      log.info("Connexion avec les informations: [identifiant: {}, motsDePassse: {}]", creds.getIdentifiant(), creds.getMotsDePasse());
      return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(creds.getIdentifiant(), creds.getMotsDePasse(), List.of())
      );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain chain,
    Authentication authResult
  ) throws IOException {
    String identifiant = ((User) authResult.getPrincipal()).getUsername();

    String token = Jwts.builder()
      .setSubject(identifiant)
      .setExpiration(new Date(System.currentTimeMillis() + securityProperties.getJwt().getExpirationDate()))
      .signWith(HS512, securityProperties.getJwt().getToken())
      .compact();

    CompteService compteService = SpringApplicationContext.getBean(CompteService.class);
    CompteDto compteDto = compteService.recupereCompteParIdentifiant(identifiant);

    response.addHeader(securityProperties.getJwt().getAuthorizationHeader(), securityProperties.jwt.getHeaderPrefix() + token);
    response.addHeader("userID", compteDto.getIdentifiant());

    CompteConnexionResponseModel compteConnexionResponseModel = new CompteConnexionResponseModel(token, compteDto);
    String writeValueAsString = new ObjectMapper().writeValueAsString(compteConnexionResponseModel);
    response.addHeader("Content-Type", APPLICATION_JSON_VALUE);
    response.getWriter().println(writeValueAsString);
  }
}
