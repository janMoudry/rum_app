package com.rum.rum.app.controllers;

import com.rum.rum.app.services.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/options")
public class OptionsController {

  @Autowired
  private OptionsService optionsService;

  @GetMapping("/aromas")
  public ResponseEntity<?> getAllAromas() {
    return optionsService.getAllAromas();
  }

  @GetMapping("/destilation")
  public ResponseEntity<?> getAllDestilation() {
    return optionsService.getAllDestilation();
  }

  @GetMapping("/brands")
  public ResponseEntity<?> getAllBrands() {
    return optionsService.getAllBrands();
  }
}
