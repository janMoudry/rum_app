package com.rum.rum.app.models;

import com.rum.rum.app.enums.CurrencyEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rum_list")
public class RumDetail {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "country")
  private String country;

  @Column(name = "destillery")
  private String destillery;

  @Column(name = "destilation")
  private String destilation;

  @Column(name = "bottled_country")
  private String bottledCountry;

  @Column(name = "type")
  private String type;

  @Column(name = "aging_style")
  private String agingStyle;

  @Column(name = "style")
  private String style;

  @Column(name = "color")
  private String color;

  @Column(name = "barrel_type")
  private String barrelType;

  @Column(name = "brand")
  private String brand;

  @Column(name = "alcohol_content")
  private String alcoholContent;

  @Column(name = "volume")
  private String volume;

  @Column(name = "price")
  private String price;

  @Column(name = "currency")
  private CurrencyEnum currency;

  @Column(name = "image")
  private String image;

  @Column(name = "size")
  private String size;

  @OneToOne
  @JoinColumn(name = "rating", referencedColumnName = "rating_id")
  private Rating rating;

  @OneToMany
  @JoinTable(
    name = "rum_list_aromas",
    joinColumns = @JoinColumn(name = "rum_detail_id"),
    inverseJoinColumns = @JoinColumn(name = "aroma_id")
  )
  private Set<Aromas> aromas;

  public RumDetail(
    String name,
    String description,
    String country,
    String destillery,
    String destilation,
    String bottledCountry,
    String type,
    String agingStyle,
    String style,
    String color,
    String barrelType,
    String brand,
    String alcoholContent,
    String volume,
    String price,
    String image,
    String size,
    Set<Aromas> aromas
  ) {
    this.name = name;
    this.description = description;
    this.country = country;
    this.destillery = destillery;
    this.destilation = destilation;
    this.bottledCountry = bottledCountry;
    this.type = type;
    this.agingStyle = agingStyle;
    this.style = style;
    this.color = color;
    this.barrelType = barrelType;
    this.brand = brand;
    this.alcoholContent = alcoholContent;
    this.volume = volume;
    this.price = price;
    this.image = image;
    this.size = size;
    this.aromas = aromas;
  }

  public boolean validateRumDetail() {
    if (this.name == null || this.name.isEmpty()) {
      return false;
    }
    if (this.description == null || this.description.isEmpty()) {
      return false;
    }
    if (this.country == null || this.country.isEmpty()) {
      return false;
    }
    if (this.destillery == null || this.destillery.isEmpty()) {
      return false;
    }
    if (this.destilation == null) {
      return false;
    }
    if (this.bottledCountry == null || this.bottledCountry.isEmpty()) {
      return false;
    }
    if (this.type == null || this.type.isEmpty()) {
      return false;
    }
    if (this.agingStyle == null || this.agingStyle.isEmpty()) {
      return false;
    }
    if (this.style == null || this.style.isEmpty()) {
      return false;
    }
    if (this.color == null || this.color.isEmpty()) {
      return false;
    }
    if (this.barrelType == null || this.barrelType.isEmpty()) {
      return false;
    }
    if (this.brand == null || this.brand.isEmpty()) {
      return false;
    }
    if (this.alcoholContent == null || this.alcoholContent.isEmpty()) {
      return false;
    }
    if (this.volume == null || this.volume.isEmpty()) {
      return false;
    }
    if (this.price == null || this.price.isEmpty()) {
      return false;
    }
    if (this.image == null || this.image.isEmpty()) {
      return false;
    }
    if (this.size == null || this.size.isEmpty()) {
      return false;
    }
    if (this.aromas == null || this.aromas.size() == 0) {
      return false;
    }

    return true;
  }

  public List<String> getMissingData() {
    if (this.name == null || this.name.isEmpty()) {
      return List.of("name");
    }
    if (this.description == null || this.description.isEmpty()) {
      return List.of("description");
    }
    if (this.country == null || this.country.isEmpty()) {
      return List.of("country");
    }
    if (this.destillery == null || this.destillery.isEmpty()) {
      return List.of("destillery");
    }
    if (this.destilation == null) {
      return List.of("destilation");
    }
    if (this.bottledCountry == null || this.bottledCountry.isEmpty()) {
      return List.of("bottledCountry");
    }
    if (this.type == null || this.type.isEmpty()) {
      return List.of("type");
    }
    if (this.agingStyle == null || this.agingStyle.isEmpty()) {
      return List.of("agingStyle");
    }
    if (this.style == null || this.style.isEmpty()) {
      return List.of("style");
    }
    if (this.color == null || this.color.isEmpty()) {
      return List.of("color");
    }
    if (this.barrelType == null || this.barrelType.isEmpty()) {
      return List.of("barrelType");
    }
    if (this.brand == null || this.brand.isEmpty()) {
      return List.of("brand");
    }
    if (this.alcoholContent == null || this.alcoholContent.isEmpty()) {
      return List.of("alcoholContent");
    }
    if (this.volume == null || this.volume.isEmpty()) {
      return List.of("volume");
    }
    if (this.price == null || this.price.isEmpty()) {
      return List.of("price");
    }
    if (this.image == null || this.image.isEmpty()) {
      return List.of("image");
    }
    if (this.size == null || this.size.isEmpty()) {
      return List.of("size");
    }
    if (this.aromas == null || this.aromas.size() == 0) {
      return List.of("aromas");
    }

    return List.of();
  }
}
