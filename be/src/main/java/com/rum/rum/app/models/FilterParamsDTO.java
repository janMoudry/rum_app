package com.rum.rum.app.models;

import com.rum.rum.app.enums.FilterBy;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@Data
public class FilterParamsDTO {

  private FilterByDTO filterParams;
  private FilterBy sort;
  private Sort.Direction order;
  private Integer page;
  private Integer itemsPerPage;
  private String search;
}
