package com.pe.populationcentersperu.domain;

import com.pe.populationcentersperu.config.ReactiveAuditingMongo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "populationCenter")
public class PopulationCenter extends ReactiveAuditingMongo {
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
