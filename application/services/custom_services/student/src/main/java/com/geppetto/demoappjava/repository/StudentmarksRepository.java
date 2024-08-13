package com.geppetto.demoappjava.repository;

import com.geppetto.demoappjava.model.Studentmarks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentmarksRepository extends MongoRepository<Studentmarks,String>  {

}
