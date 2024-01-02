package com.rum.rum.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class test {

  @GetMapping("/test")
  public String testEndpoint() {
    return "Hello, World!";
  }
}
