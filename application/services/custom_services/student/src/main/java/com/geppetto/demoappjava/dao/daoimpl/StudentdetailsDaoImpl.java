package com.geppetto.demoappjava.dao.daoimpl;

import com.geppetto.demoappjava.model.Studentdetails;
import com.geppetto.demoappjava.repository.StudentdetailsRepository;
import com.geppetto.demoappjava.dao.StudentdetailsDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentdetailsDaoImpl implements StudentdetailsDao{

    private final StudentdetailsRepository studentdetailsRepository;

     public StudentdetailsDaoImpl(StudentdetailsRepository studentdetailsRepository) {
       this.studentdetailsRepository = studentdetailsRepository;
}

    @Override
    public Studentdetails create(Studentdetails studentdetails) {
      return studentdetailsRepository.save(studentdetails);
    }


    @Override
    public Optional<Studentdetails> getEntityById(String id) {
      return studentdetailsRepository.findById(id);
    }


    @Override
    public List<Studentdetails> getAllValues() {
      return studentdetailsRepository.findAll();
    }


    @Override
    public Optional<Studentdetails> update(String id) {
      return studentdetailsRepository.findById(id);
    }


    @Override
    public void delete(String id) {
      studentdetailsRepository.deleteById(id);
    }

}
