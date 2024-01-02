package com.rum.rum.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private final BasicAutentifications basicAuthentications;

  public WebMvcConfig(BasicAutentifications basicAuthentications) {
    this.basicAuthentications = basicAuthentications;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(basicAuthentications);
  }
}
