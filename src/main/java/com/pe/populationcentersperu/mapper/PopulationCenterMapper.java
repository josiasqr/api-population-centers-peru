package com.pe.populationcentersperu.mapper;

import com.pe.populationcentersperu.domain.PopulationCenter;
import com.pe.populationcentersperu.domain.PopulationCenterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PopulationCenterMapper {
  PopulationCenterResponse sourceToPopulationCenterResponse(PopulationCenter populationCenter);
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "_id", ignore = true)
  PopulationCenter sourceToPopulationCenter(PopulationCenterResponse populationCenterResponse);
}
