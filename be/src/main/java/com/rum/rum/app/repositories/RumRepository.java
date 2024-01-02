package com.rum.rum.app.repositories;

import com.rum.rum.app.models.RumDetail;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RumRepository extends JpaRepository<RumDetail, UUID> {
  public Optional<RumDetail> findById(UUID id);

  public boolean existsByName(String name);

  public RumDetail findByName(String name);

  public Page<RumDetail> findAll(Pageable pageable);

  public Page<RumDetail> findByNameContainingIgnoreCase(
    String name,
    Pageable pageable
  );

  public Page<RumDetail> findAll(
    Specification<RumDetail> spec,
    Pageable pageable
  );
}
