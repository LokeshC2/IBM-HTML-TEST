package org.ibm.rateservice.repository;

import org.ibm.rateservice.model.RateModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RateRepository extends MongoRepository<RateModel, String> {
  @Query("{'from': ?0, 'to': ?1}")
  RateModel findByFromAndTo(String from, String to);
}
