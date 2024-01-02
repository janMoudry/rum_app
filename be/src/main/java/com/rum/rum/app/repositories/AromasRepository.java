package com.rum.rum.app.repositories;

import com.rum.rum.app.models.Aromas;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AromasRepository extends JpaRepository<Aromas, UUID> {
  Optional<Aromas> findByAromaName(String aromaName);
}
