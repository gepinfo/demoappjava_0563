package com.geppetto.demoappjava.service.serviceimpl;

import com.geppetto.demoappjava.dao.StudentmarksDao;
import com.geppetto.demoappjava.model.Studentmarks;
import com.geppetto.demoappjava.dto.StudentmarksDto;
import com.geppetto.demoappjava.service.StudentmarksService;
import com.geppetto.demoappjava.exception.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentmarksServiceImpl implements StudentmarksService{

      private final StudentmarksDao studentmarksDao;

      private final MongoTemplate mongoTemplate;
      public StudentmarksServiceImpl(StudentmarksDao  studentmarksDao,MongoTemplate mongoTemplate) {
          this. studentmarksDao =  studentmarksDao;
          this.mongoTemplate=mongoTemplate;
}

    @Override
    public StudentmarksDto create(StudentmarksDto studentmarksDto){
        Studentmarks studentmarks = new Studentmarks();
        BeanUtils.copyProperties(studentmarksDto, studentmarks);
        Studentmarks createdStudentmarks= studentmarksDao.create(studentmarks);
        BeanUtils.copyProperties(createdStudentmarks, studentmarksDto);
        return studentmarksDto;
    }


    @Override
    public StudentmarksDto getEntityById(String id) {
    StudentmarksDto studentmarksDto = new StudentmarksDto();
    Optional<Studentmarks> result = studentmarksDao.getEntityById(id);
        if (result.isPresent()) {
            BeanUtils.copyProperties(result.get(), studentmarksDto);
        } else {
            throw new EntityNotFoundException("Data not found for ID: " + id);
        }
        return studentmarksDto;
    }


    @Override
    public List<StudentmarksDto> getAllValues() {
        List<Studentmarks> studentmarksEntities = studentmarksDao.getAllValues();
        List<StudentmarksDto> studentmarksDtoList = new ArrayList<>();
        for (Studentmarks studentmarksEntity : studentmarksEntities) {
            StudentmarksDto studentmarksDto = new StudentmarksDto();
            BeanUtils.copyProperties(studentmarksEntity, studentmarksDto);
            studentmarksDtoList.add(studentmarksDto);
        }
        return studentmarksDtoList;
    }



    @Override
    public StudentmarksDto update(StudentmarksDto studentmarksDto) {
    Optional<Studentmarks> result = studentmarksDao.update(studentmarksDto.get_id());
        if (result.isPresent()) {
           Studentmarks studentmarks = result.get();
           BeanUtils.copyProperties(studentmarksDto, studentmarks);
           studentmarksDao.create(studentmarks);
           return studentmarksDto;
        } else {
        throw new EntityNotFoundException("Data not found for update with ID: " + studentmarksDto.get_id());
        }
    }


    @Override
    public String delete(String id) {
    Optional<Studentmarks> result = studentmarksDao.getEntityById(id);
        if (result.isPresent()) {
            studentmarksDao.delete(id);
        }else{
        throw new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete.");
        }
        return "Data Deleted Successfully";
    }



    private String constructQuery(Map<String, String> params) {
       StringBuilder queryBuilder = new StringBuilder("{ ");
         for (Map.Entry<String, String> entry : params.entrySet()) {
         queryBuilder.append(entry.getKey()).append(": '").append(entry.getValue()).append("', ");
    }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length()).append(" }");
        return queryBuilder.toString();
    }
}