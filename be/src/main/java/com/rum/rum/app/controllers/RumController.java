package com.rum.rum.app.controllers;

import com.rum.rum.app.models.FilterParamsDTO;
import com.rum.rum.app.models.RumDetail;
import com.rum.rum.app.services.RumService;
import jakarta.ws.rs.QueryParam;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rums")
public class RumController {

  @Autowired
  private RumService rumService;

  @PostMapping("/create")
  public ResponseEntity<Object> createRum(@RequestBody RumDetail rumDetail) {
    return rumService.createRum(rumDetail);
  }

  @PostMapping("/get-list")
  public ResponseEntity<Object> listRums(
    @RequestBody FilterParamsDTO filterParamsDTO
  ) {
    return rumService.listRums(filterParamsDTO);
  }

  @GetMapping("/get-detail")
  public ResponseEntity<Object> getRumDetail(@QueryParam("id") UUID id) {
    return rumService.getRumDetail(id);
  }

  @GetMapping("/get-rating")
  public ResponseEntity<Object> getRumRating(@QueryParam("id") UUID id) {
    return rumService.getRumRating(id);
  }

  @PutMapping("/update-rating")
  public ResponseEntity<Object> updateRumRating(
    @QueryParam("id") UUID id,
    @QueryParam("rating") int rating
  ) {
    return rumService.updateRumRating(id, rating);
  }
}
