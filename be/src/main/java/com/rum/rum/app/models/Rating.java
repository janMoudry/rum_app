package com.rum.rum.app.models;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Data
@Table(name = "rating")
public class Rating {

  @Id
  @Column(name = "rating_id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_overall", referencedColumnName = "id")
  private RatingDTO ratingOverall;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_aroma", referencedColumnName = "id")
  private RatingDTO ratingAroma;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_taste", referencedColumnName = "id")
  private RatingDTO ratingTaste;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_aftertaste", referencedColumnName = "id")
  private RatingDTO ratingAftertaste;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_balance", referencedColumnName = "id")
  private RatingDTO ratingBalance;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_complexity", referencedColumnName = "id")
  private RatingDTO ratingComplexity;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_smoothness", referencedColumnName = "id")
  private RatingDTO ratingSmoothness;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rating_valueForMoney", referencedColumnName = "id")
  private RatingDTO ratingValueForMoney;
}
