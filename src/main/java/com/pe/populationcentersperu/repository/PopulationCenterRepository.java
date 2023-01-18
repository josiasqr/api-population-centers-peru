package com.pe.populationcentersperu.repository;

import com.pe.populationcentersperu.domain.PopulationCenter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopulationCenterRepository extends ReactiveMongoRepository<PopulationCenter, String> {
}
