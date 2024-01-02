package com.rum.rum.app.services;

import com.rum.rum.app.enums.RumTypeDestilation;
import com.rum.rum.app.repositories.AromasRepository;
import com.rum.rum.app.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OptionsService {

  @Autowired
  private AromasRepository aromasRepository;

  public ResponseEntity<Object> getAllAromas() {
    return ResponseHandler.ok(aromasRepository.findAll());
  }

  public ResponseEntity<Object> getAllDestilation() {
    RumTypeDestilation[] destilation = RumTypeDestilation.values();

    String[] destilationString = new String[destilation.length];

    for (int i = 0; i < destilation.length; i++) {
      destilationString[i] = destilation[i].toString();
    }

    return ResponseHandler.ok(destilationString);
  }

  public ResponseEntity<Object> getAllBrands() {
    return ResponseHandler.ok();
  }
}
