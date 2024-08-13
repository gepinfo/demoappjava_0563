package com.geppetto.demoappjava.dao;

import com.geppetto.demoappjava.model.Studentmarks;
import java.util.List;
import java.util.Optional;


public interface StudentmarksDao {

    Studentmarks create(Studentmarks studentmarks);


    Optional<Studentmarks> getEntityById(String id);


    List<Studentmarks> getAllValues();


    Optional<Studentmarks> update(String id);


    void delete(String id);

}
