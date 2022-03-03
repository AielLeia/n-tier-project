package fr.mai.ntiers.config.security;

import fr.mai.ntiers.config.properties.SecurityProperties;
import io.jsonwebtoken.Jwts;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.List.of;

public class AuthorizationFilter extends BasicAuthenticationFilter {

  private final SecurityProperties securityProperties;

  public AuthorizationFilter(
    AuthenticationManager authenticationManager,
    SecurityProperties securityProperties
  ) {
    super(authenticationManager);
    this.securityProperties = securityProperties;
  }


  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain chain
  ) throws IOException, ServletException {
    String header = request.getHeader(securityProperties.getJwt().getAuthorizationHeader());
    if (header == null || !header.startsWith(securityProperties.getJwt().getHeaderPrefix())) {
      chain.doFilter(request, response);
      return;
    }

    UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    chain.doFilter(request, response);
  }

  private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
    AtomicReference<String> token = new AtomicReference<>(request.getHeader(securityProperties.getJwt().getAuthorizationHeader()));

    if (token.get() != null) {
      token.set(token.get().replace(securityProperties.getJwt().getHeaderPrefix(), ""));

      String user = Jwts.parser()
        .setSigningKey(securityProperties.getJwt().getToken())
        .parseClaimsJws(token.get())
        .getBody()
        .getSubject();
      if (user != null) return new UsernamePasswordAuthenticationToken(user, null, of());
    }

    return null;
  }
}
