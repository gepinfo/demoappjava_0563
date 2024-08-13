package com.geppetto.demoappjava.repository;

import com.geppetto.demoappjava.model.Stduentrank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StduentrankRepository extends MongoRepository<Stduentrank,String>  {

}
