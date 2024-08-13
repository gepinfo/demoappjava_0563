package com.geppetto.demoappjava.dao.daoimpl;

import com.geppetto.demoappjava.model.Studentmarks;
import com.geppetto.demoappjava.repository.StudentmarksRepository;
import com.geppetto.demoappjava.dao.StudentmarksDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentmarksDaoImpl implements StudentmarksDao{

    private final StudentmarksRepository studentmarksRepository;

     public StudentmarksDaoImpl(StudentmarksRepository studentmarksRepository) {
       this.studentmarksRepository = studentmarksRepository;
}

    @Override
    public Studentmarks create(Studentmarks studentmarks) {
      return studentmarksRepository.save(studentmarks);
    }


    @Override
    public Optional<Studentmarks> getEntityById(String id) {
      return studentmarksRepository.findById(id);
    }


    @Override
    public List<Studentmarks> getAllValues() {
      return studentmarksRepository.findAll();
    }


    @Override
    public Optional<Studentmarks> update(String id) {
      return studentmarksRepository.findById(id);
    }


    @Override
    public void delete(String id) {
      studentmarksRepository.deleteById(id);
    }

}
