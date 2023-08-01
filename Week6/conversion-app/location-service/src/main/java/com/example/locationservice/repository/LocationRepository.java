package com.example.locationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.locationservice.model.LocationEntity;

public interface LocationRepository extends MongoRepository<LocationEntity, String>{
  
}
