package com.pe.populationcentersperu.service.populationcenter;

import com.pe.populationcentersperu.domain.PopulationCenter;
import com.pe.populationcentersperu.mapper.PopulationCenterMapper;
import com.pe.populationcentersperu.repository.PopulationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InPopulationCenterService implements PopulationCenterService {
  @Autowired
  private PopulationCenterRepository populationCenterRepository;
  
  @Autowired
  private PopulationCenterMapper populationCenterMapper;
  
  
  @Override
  public Flux<PopulationCenter> listAll() {
    return populationCenterRepository.findAll();
  }
  
  @Override
  public Mono<PopulationCenter> getById(String _id) {
    return populationCenterRepository.findById(_id);
  }
  
  @Override
  public Mono<PopulationCenter> create(PopulationCenter populationCenter) {
    return populationCenterRepository.save(populationCenter);
  }
  
  @Override
  public Mono<PopulationCenter> edit(PopulationCenter populationCenter) {
    return populationCenterRepository.save(populationCenter);
  }
  
  @Override
  public Mono<Void> delete(String _id) {
    return populationCenterRepository.deleteById(_id);
  }
}
