package org.ibm.conversionservice.repository;

import org.ibm.conversionservice.model.ConversionRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversionRepository extends MongoRepository<ConversionRequest, String>{
}
