package com.geppetto.demoappjava.dao.daoimpl;

import com.geppetto.demoappjava.model.Stduentrank;
import com.geppetto.demoappjava.repository.StduentrankRepository;
import com.geppetto.demoappjava.dao.StduentrankDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StduentrankDaoImpl implements StduentrankDao{

    private final StduentrankRepository stduentrankRepository;

     public StduentrankDaoImpl(StduentrankRepository stduentrankRepository) {
       this.stduentrankRepository = stduentrankRepository;
}

    @Override
    public Stduentrank create(Stduentrank stduentrank) {
      return stduentrankRepository.save(stduentrank);
    }


    @Override
    public Optional<Stduentrank> getEntityById(String id) {
      return stduentrankRepository.findById(id);
    }


    @Override
    public List<Stduentrank> getAllValues() {
      return stduentrankRepository.findAll();
    }


    @Override
    public Optional<Stduentrank> update(String id) {
      return stduentrankRepository.findById(id);
    }


    @Override
    public void delete(String id) {
      stduentrankRepository.deleteById(id);
    }

}
