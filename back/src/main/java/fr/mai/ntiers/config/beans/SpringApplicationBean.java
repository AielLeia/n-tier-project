package fr.mai.ntiers.config.beans;

import fr.mai.ntiers.SpringApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringApplicationBean {

  @Bean
  public SpringApplicationContext springApplicationContext() {
    return new SpringApplicationContext();
  }
}
