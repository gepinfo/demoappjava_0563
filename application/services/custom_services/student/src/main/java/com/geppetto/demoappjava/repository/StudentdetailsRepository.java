package com.geppetto.demoappjava.repository;

import com.geppetto.demoappjava.model.Studentdetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentdetailsRepository extends MongoRepository<Studentdetails,String>  {

}
