package fr.mai.ntiers.config.properties;

import fr.mai.ntiers.config.beans.YamlPropertiesSourceLoader;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "security")
@PropertySource(value = "classpath:/security.yml", factory = YamlPropertiesSourceLoader.class)
@Data
public class SecurityProperties {

  @NestedConfigurationProperty
  public JwtProperties jwt;

  @NestedConfigurationProperty
  private AuthorizedUrl authorizedUrl;

  @Data
  public static class JwtProperties {

    private String token;

    private String headerPrefix;

    private String authorizationHeader;

    private Long expirationDate;
  }

  @Data
  public static class AuthorizedUrl {

    private String registerUrl;

    private String loginUrl;
  }
}
