package com.pe.populationcentersperu.controller;

import com.pe.populationcentersperu.domain.PopulationCenterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PopulationCenterController {
  @GetMapping
  Mono<ResponseEntity<Flux<PopulationCenterResponse>>> list();

  @GetMapping("/{populationCenterId}")
  Mono<ResponseEntity<PopulationCenterResponse>> findById(@PathVariable("populationCenterId")
                                                          String _id);

  @PostMapping
  Mono<ResponseEntity<PopulationCenterResponse>> create(@RequestBody
                                                        PopulationCenterResponse populationCenterResponse);

  @PutMapping("{populationCenterId}")
  Mono<ResponseEntity<PopulationCenterResponse>> edit(@PathVariable("populationCenterId") String _id,
                                                      @RequestBody PopulationCenterResponse populationCenterResponse);

  @DeleteMapping("{populationCenterId}")
  Mono<ResponseEntity<Void>> delete(@PathVariable("populationCenterId") String _id);
}
