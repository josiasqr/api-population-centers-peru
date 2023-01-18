package com.pe.populationcentersperu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@EnableReactiveMongoAuditing
@SpringBootApplication
public class PopulationCentersApplication {
  public static void main(String[] args) {
    SpringApplication.run(PopulationCentersApplication.class, args);
  }
}
