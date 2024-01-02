package com.rum.rum.app.utils;

import com.rum.rum.app.models.Aromas;
import com.rum.rum.app.models.FilterByDTO;
import com.rum.rum.app.models.RumDetail;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CreateSpecification {

  public static Specification<RumDetail> create(FilterByDTO filterParams) {
    return (
      Root<RumDetail> root,
      CriteriaQuery<?> query,
      CriteriaBuilder builder
    ) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (filterParams.getName() != null) {
        predicates.add(
          builder.like(root.get("name"), "%" + filterParams.getName() + "%")
        );
      }

      if (filterParams.getCountry() != null) {
        predicates.add(
          builder.like(
            root.get("country"),
            "%" + filterParams.getCountry() + "%"
          )
        );
      }

      if (filterParams.getDestillery() != null) {
        predicates.add(
          builder.like(
            root.get("destillery"),
            "%" + filterParams.getDestillery() + "%"
          )
        );
      }

      if (filterParams.getDestilation() != null) {
        predicates.add(
          builder.equal(root.get("destilation"), filterParams.getDestilation())
        );
      }

      if (filterParams.getBottledCountry() != null) {
        predicates.add(
          builder.like(
            root.get("bottledCountry"),
            "%" + filterParams.getBottledCountry() + "%"
          )
        );
      }

      if (filterParams.getType() != null) {
        predicates.add(builder.equal(root.get("type"), filterParams.getType()));
      }

      if (filterParams.getAgingStyle() != null) {
        predicates.add(
          builder.equal(root.get("agingStyle"), filterParams.getAgingStyle())
        );
      }

      if (filterParams.getStyle() != null) {
        predicates.add(
          builder.equal(root.get("style"), filterParams.getStyle())
        );
      }

      if (filterParams.getColor() != null) {
        predicates.add(
          builder.equal(root.get("color"), filterParams.getColor())
        );
      }

      if (filterParams.getBarrelType() != null) {
        predicates.add(
          builder.equal(root.get("barrelType"), filterParams.getBarrelType())
        );
      }

      if (filterParams.getBrand() != null) {
        predicates.add(
          builder.like(root.get("brand"), "%" + filterParams.getBrand() + "%")
        );
      }

      if (filterParams.getAlcoholContent() != null) {
        predicates.add(
          builder.equal(
            root.get("alcoholContent"),
            filterParams.getAlcoholContent()
          )
        );
      }

      if (filterParams.getVolume() != null) {
        predicates.add(
          builder.equal(root.get("volume"), filterParams.getVolume())
        );
      }

      if (filterParams.getPrice() != null) {
        predicates.add(
          builder.equal(root.get("price"), filterParams.getPrice())
        );
      }

      if (filterParams.getSize() != null) {
        predicates.add(builder.equal(root.get("size"), filterParams.getSize()));
      }

      if (
        filterParams.getAromas() != null && filterParams.getAromas().length != 0
      ) {
        SetJoin<RumDetail, Aromas> aromasJoin = root.joinSet("aromas");
        List<Predicate> aromaPredicates = new ArrayList<>();
        for (String aroma : filterParams.getAromas()) {
          aromaPredicates.add(
            builder.equal(aromasJoin.get("aromaName"), aroma)
          );
        }
        predicates.add(builder.or(aromaPredicates.toArray(new Predicate[0])));
      }

      if (filterParams.getRating() != null) {
        predicates.add(
          builder.greaterThanOrEqualTo(
            root.get("rating"),
            filterParams.getRating()
          )
        );
      }

      return builder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
