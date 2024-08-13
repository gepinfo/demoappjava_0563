package com.geppetto.demoappjava.dao;

import com.geppetto.demoappjava.model.Studentdetails;
import java.util.List;
import java.util.Optional;


public interface StudentdetailsDao {

    Studentdetails create(Studentdetails studentdetails);


    Optional<Studentdetails> getEntityById(String id);


    List<Studentdetails> getAllValues();


    Optional<Studentdetails> update(String id);


    void delete(String id);

}
