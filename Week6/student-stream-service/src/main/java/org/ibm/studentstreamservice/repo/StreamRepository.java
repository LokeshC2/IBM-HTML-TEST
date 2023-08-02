package org.ibm.studentstreamservice.repo;

import org.ibm.studentstreamservice.model.Stream;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StreamRepository extends MongoRepository<Stream, String> {
    
}
