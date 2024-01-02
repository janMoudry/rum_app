package com.rum.rum.app.services;

import com.rum.rum.app.models.Aromas;
import com.rum.rum.app.models.FilterByDTO;
import com.rum.rum.app.models.FilterParamsDTO;
import com.rum.rum.app.models.Rating;
import com.rum.rum.app.models.RatingDTO;
import com.rum.rum.app.models.RumDetail;
import com.rum.rum.app.repositories.AromasRepository;
import com.rum.rum.app.repositories.RatingRepository;
import com.rum.rum.app.repositories.RatingRepositoryDetail;
import com.rum.rum.app.repositories.RumRepository;
import com.rum.rum.app.utils.CreateSpecification;
import com.rum.rum.app.utils.ResponseHandler;
import com.rum.rum.app.utils.UpdateOptions;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RumService {

  @Autowired
  private RumRepository rumRepository;

  @Autowired
  private AromasRepository aromasRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private RatingRepositoryDetail ratingRepositoryDetail;

  public ResponseEntity<Object> createRum(RumDetail rumDetail) {
    boolean isValid = rumDetail.validateRumDetail();

    if (!isValid) {
      List<String> errors = rumDetail.getMissingData();
      return ResponseHandler.badRequest(errors);
    }

    if (rumRepository.existsByName(rumDetail.getName())) {
      return ResponseHandler.alreadyExist();
    }

    Set<Aromas> managedAromas = new HashSet<>();
    for (Aromas aroma : rumDetail.getAromas()) {
      Optional<Aromas> existingAroma = aromasRepository.findByAromaName(
        aroma.getAromaName()
      );

      RatingDTO ratingDTO = new RatingDTO();

      ratingDTO.initWithZeros();

      ratingRepositoryDetail.save(ratingDTO);

      Rating rating = new Rating();

      rating.setRatingAftertaste(ratingDTO);
      rating.setRatingAroma(ratingDTO);
      rating.setRatingBalance(ratingDTO);
      rating.setRatingComplexity(ratingDTO);
      rating.setRatingOverall(ratingDTO);
      rating.setRatingSmoothness(ratingDTO);
      rating.setRatingTaste(ratingDTO);
      rating.setRatingValueForMoney(ratingDTO);

      ratingRepository.save(rating);

      rumDetail.setRating(rating);

      if (existingAroma.isEmpty()) {
        Aromas createdAroma = aromasRepository.save(aroma);
        managedAromas.add(createdAroma);
      } else {
        managedAromas.add(existingAroma.get());
      }
    }
    rumDetail.setAromas(managedAromas);

    RumDetail createdRum = rumRepository.save(rumDetail);

    UpdateOptions.checkAndSaveNewData(rumDetail);

    return ResponseEntity.ok(createdRum);
  }

  public ResponseEntity<Object> listRums(FilterParamsDTO filterParamsDTO) {
    Integer page = filterParamsDTO.getPage();
    Integer itemsPerPage = filterParamsDTO.getItemsPerPage();

    Sort sort = Sort.by(
      filterParamsDTO.getOrder(),
      filterParamsDTO.getSort().toString().toLowerCase()
    );

    Pageable pageable = PageRequest.of(page, itemsPerPage, sort);

    if (page == null || itemsPerPage == null) {
      return ResponseHandler.badRequest(null);
    }

    FilterByDTO filterParams = filterParamsDTO.getFilterParams();

    if (filterParams != null) {
      Specification<RumDetail> spec = CreateSpecification.create(filterParams);

      Page<RumDetail> rums = rumRepository.findAll(spec, pageable);

      return ResponseEntity.ok(rums);
    }

    if (filterParamsDTO.getSearch() != null) {
      String search = filterParamsDTO.getSearch();

      Page<RumDetail> rums = rumRepository.findByNameContainingIgnoreCase(
        search,
        pageable
      );

      return ResponseEntity.ok(rums);
    }

    Page<RumDetail> rums = rumRepository.findAll(pageable);

    return ResponseEntity.ok(rums);
  }

  public ResponseEntity<Object> getRumDetail(UUID id) {
    Optional<RumDetail> rumDetail = rumRepository.findById(id);

    if (rumDetail.isEmpty()) {
      return ResponseHandler.notFound();
    }

    return ResponseEntity.ok(rumDetail.get());
  }

  public ResponseEntity<Object> getRumRating(UUID id) {
    Optional<RumDetail> rumDetail = rumRepository.findById(id);

    if (rumDetail.isEmpty()) {
      return ResponseHandler.notFound();
    }

    return ResponseEntity.ok(rumDetail.get());
  }

  public ResponseEntity<Object> updateRumRating(UUID id, int rating) {
    // rating will be here
    return null;
  }
}
