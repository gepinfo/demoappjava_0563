package com.geppetto.demoappjava.repository;

import com.geppetto.demoappjava.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>  {

}
