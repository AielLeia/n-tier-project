package fr.mai.ntiers.config.security;

import fr.mai.ntiers.config.properties.SecurityProperties;
import fr.mai.ntiers.service.CompteService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final SecurityProperties securityProperties;

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  private final CompteService compteService;

  public WebSecurityConfiguration(
    SecurityProperties securityProperties,
    BCryptPasswordEncoder bCryptPasswordEncoder,
    CompteService compteService
  ) {
    this.securityProperties = securityProperties;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.compteService = compteService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.headers().frameOptions().disable();
    http
      // Ajout du système de cors simple et basique
      .cors().and()

      // Suppression de la vérification automatique to token csrf
      .csrf().disable()

      // Url autorisé à être utilisées sans token jwt
      .authorizeHttpRequests()
      .antMatchers(POST, securityProperties.getAuthorizedUrl().getRegisterUrl()).permitAll() // Url d'enregistrement
      .antMatchers(POST, securityProperties.getAuthorizedUrl().getLoginUrl()).permitAll() // Url de login
      .antMatchers(securityProperties.getAuthorizedUrl().getH2ConsoleUrl()).permitAll() // Url de h2
      .and()


      // Tout les requêtes aurons besoins d'une authentification
      .authorizeHttpRequests()
      .anyRequest()
      .authenticated().and()

      // Filters
      .addFilter(getAuthenticationFilter())

      // On ne sauvegarde pas en session le token
      .sessionManagement()
      .sessionCreationPolicy(STATELESS)
    ;

  }

  private AuthenticationFilter getAuthenticationFilter() throws Exception {
    AuthenticationFilter authenticationFilter = new AuthenticationFilter(securityProperties, authenticationManager());
    authenticationFilter.setFilterProcessesUrl(securityProperties.getAuthorizedUrl().getLoginUrl());
    return authenticationFilter;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(this.compteService).passwordEncoder(bCryptPasswordEncoder);
  }
}
