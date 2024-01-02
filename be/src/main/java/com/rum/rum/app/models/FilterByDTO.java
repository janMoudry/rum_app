package com.rum.rum.app.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FilterByDTO {

  String name;
  String country;
  String destillery;
  String destilation;
  String bottledCountry;
  String type;
  String agingStyle;
  String style;
  String color;
  String barrelType;
  String brand;
  String alcoholContent;
  String volume;
  String price;
  String size;
  String[] aromas;
  Double rating;
}
