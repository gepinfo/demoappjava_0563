package com.geppetto.demoappjava.dao;

import com.geppetto.demoappjava.model.Stduentrank;
import java.util.List;
import java.util.Optional;


public interface StduentrankDao {

    Stduentrank create(Stduentrank stduentrank);


    Optional<Stduentrank> getEntityById(String id);


    List<Stduentrank> getAllValues();


    Optional<Stduentrank> update(String id);


    void delete(String id);

}
