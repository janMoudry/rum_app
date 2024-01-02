package com.rum.rum.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EntityScan
public class RumAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(RumAppApplication.class, args);
  }
}
