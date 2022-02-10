package fr.mai.ntiers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {
  private static ApplicationContext CONTEXT;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringApplicationContext.CONTEXT = applicationContext;
  }

  public static <T> T getBean(String beanName, Class<T> clazz) {
    return SpringApplicationContext.CONTEXT.getBean(beanName, clazz);
  }

  public static <T> T getBean(Class<T> clazz) {
    return SpringApplicationContext.CONTEXT.getBean(clazz);
  }
}

