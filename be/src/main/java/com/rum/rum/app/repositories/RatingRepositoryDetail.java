package com.rum.rum.app.repositories;

import com.rum.rum.app.models.RatingDTO;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepositoryDetail
  extends JpaRepository<RatingDTO, UUID> {}
