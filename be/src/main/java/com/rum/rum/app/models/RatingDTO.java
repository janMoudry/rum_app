package com.rum.rum.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Data
@Entity
@Table(name = "rating_details")
public class RatingDTO {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "rating")
  private Double rating;

  @Column(name = "votes")
  private Integer votes;

  @Column(name = "numberOf1Stars")
  private Integer numberOf1Stars;

  @Column(name = "numberOf2Stars")
  private Integer numberOf2Stars;

  @Column(name = "numberOf3Stars")
  private Integer numberOf3Stars;

  @Column(name = "numberOf4Stars")
  private Integer numberOf4Stars;

  @Column(name = "numberOf5Stars")
  private Integer numberOf5Stars;

  @Column(name = "median")
  private Integer median;

  @Column(name = "mode")
  private Integer mode;

  public void initWithZeros() {
    this.rating = 0.0;
    this.votes = 0;
    this.numberOf1Stars = 0;
    this.numberOf2Stars = 0;
    this.numberOf3Stars = 0;
    this.numberOf4Stars = 0;
    this.numberOf5Stars = 0;
    this.median = 0;
    this.mode = 0;
  }
}
