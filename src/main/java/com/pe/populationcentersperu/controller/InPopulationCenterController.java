package com.pe.populationcentersperu.controller;

import com.pe.populationcentersperu.domain.PopulationCenterResponse;
import com.pe.populationcentersperu.mapper.PopulationCenterMapper;
import com.pe.populationcentersperu.service.populationcenter.PopulationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/population-centers")
public class InPopulationCenterController implements PopulationCenterController {
  @Autowired
  private PopulationCenterService populationCenterService;
  @Autowired
  private PopulationCenterMapper populationCenterMapper;

  @Override
  public Mono<ResponseEntity<Flux<PopulationCenterResponse>>> list() {
    return Mono.just(ResponseEntity.ok(populationCenterService.listAll()
          .map(populationCenterMapper::sourceToPopulationCenterResponse)));
  }

  @Override
  public Mono<ResponseEntity<PopulationCenterResponse>> findById(String _id) {
    return populationCenterService.getById(_id)
          .map(response -> ResponseEntity.ok(populationCenterMapper.sourceToPopulationCenterResponse(response)))
          .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @Override
  public Mono<ResponseEntity<PopulationCenterResponse>> create(PopulationCenterResponse
                                                                     populationCenterResponse) {
    return populationCenterService.create(populationCenterMapper.sourceToPopulationCenter(populationCenterResponse))
          .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(
                populationCenterMapper.sourceToPopulationCenterResponse(response)));
  }

  @Override
  public Mono<ResponseEntity<PopulationCenterResponse>> edit(String _id, PopulationCenterResponse
        populationCenterResponse) {
    return populationCenterService.getById(_id)
          .flatMap(response -> {
            response.set_id(_id);
            response.setPopulationCenter(populationCenterResponse.getPopulationCenter());

            return populationCenterService.edit(response)
                  .map(populationCenterMapper::sourceToPopulationCenterResponse);
          })
          .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
          .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @Override
  public Mono<ResponseEntity<Void>> delete(String id) {
    return populationCenterService.getById(id)
          .flatMap(response -> populationCenterService.delete(id)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
          .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }
}
