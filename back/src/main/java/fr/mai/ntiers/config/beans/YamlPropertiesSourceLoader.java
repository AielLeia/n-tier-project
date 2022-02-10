package fr.mai.ntiers.config.beans;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.Properties;

import static java.util.Objects.requireNonNull;

public class YamlPropertiesSourceLoader implements PropertySourceFactory {

  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource resource) {
    YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
    factory.setResources(resource.getResource());

    Properties properties = factory.getObject();

    return new PropertiesPropertySource(requireNonNull(resource.getResource().getFilename()), requireNonNull(properties));
  }
}