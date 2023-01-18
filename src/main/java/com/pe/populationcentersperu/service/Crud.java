package com.pe.populationcentersperu.service;

import com.pe.populationcentersperu.domain.PopulationCenter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Crud<T> {
  Flux<T> listAll();
  
  Mono<T> getById(String id);
  
  Mono<T> create(T t);
  
  Mono<T> edit(PopulationCenter populationCenter);
  
  Mono<Void> delete(String id);
}
