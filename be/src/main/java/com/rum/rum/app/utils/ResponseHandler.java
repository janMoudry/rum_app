package com.rum.rum.app.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

  public static ResponseEntity<Object> notFound() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "404");
    map.put("message", "Not Found");
    map.put("message_cz", "Nenalezeno");

    return ResponseEntity.status(404).body(map);
  }

  public static ResponseEntity<Object> badRequest(List<String> errors) {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "400");
    map.put("message", "Bad Request");
    map.put("message_cz", "Špatný požadavek");
    map.put("errors", errors);

    return ResponseEntity.status(400).body(map);
  }

  public static ResponseEntity<Object> ok() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "200");
    map.put("message", "OK");
    map.put("message_cz", "OK");

    return ResponseEntity.status(200).body(map);
  }

  public static ResponseEntity<Object> ok(Object data) {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "200");
    map.put("message", "OK");
    map.put("message_cz", "OK");
    map.put("data", data);

    return ResponseEntity.status(200).body(map);
  }

  public static ResponseEntity<Object> created() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "201");
    map.put("message", "Created");
    map.put("message_cz", "Vytvořeno");

    return ResponseEntity.status(201).body(map);
  }

  public static ResponseEntity<Object> unauthorized() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "401");
    map.put("message", "Unauthorized");
    map.put("message_cz", "Neautorizováno");

    return ResponseEntity.status(401).body(map);
  }

  public static ResponseEntity<Object> forbidden() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "403");
    map.put("message", "Forbidden");
    map.put("message_cz", "Zakázáno");

    return ResponseEntity.status(403).body(map);
  }

  public static ResponseEntity<Object> internalServerError() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "500");
    map.put("message", "Internal Server Error");
    map.put("message_cz", "Interní chyba serveru");

    return ResponseEntity.status(500).body(map);
  }

  public static ResponseEntity<Object> serviceUnavailable() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "503");
    map.put("message", "Service Unavailable");
    map.put("message_cz", "Služba nedostupná");

    return ResponseEntity.status(503).body(map);
  }

  public static ResponseEntity<Object> notImplemented() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "501");
    map.put("message", "Not Implemented");
    map.put("message_cz", "Není implementováno");

    return ResponseEntity.status(501).body(map);
  }

  public static ResponseEntity<Object> alreadyExist() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", "409");
    map.put("message", "Already Exist");
    map.put("message_cz", "Už existuje");

    return ResponseEntity.status(409).body(map);
  }
}
