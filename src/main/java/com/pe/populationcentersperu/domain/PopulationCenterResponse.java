package com.pe.populationcentersperu.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PopulationCenterResponse {
  private String _id;
  private String ubigeoCode;
  private String departament;
  private String province;
  private String district;
  private String populationCenter;
  private String description;
  private BigDecimal length;
  private BigDecimal latitude;
  private Double altitude;
  private Integer population;
  private Integer livingPlace;
  private Integer timeMinutesToDistrictCapital;
  private String language;
}
