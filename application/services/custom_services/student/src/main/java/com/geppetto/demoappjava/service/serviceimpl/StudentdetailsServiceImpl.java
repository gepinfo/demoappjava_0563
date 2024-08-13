package com.geppetto.demoappjava.service.serviceimpl;

import com.geppetto.demoappjava.dao.StudentdetailsDao;
import com.geppetto.demoappjava.model.Studentdetails;
import com.geppetto.demoappjava.dto.StudentdetailsDto;
import com.geppetto.demoappjava.service.StudentdetailsService;
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
public class StudentdetailsServiceImpl implements StudentdetailsService{

      private final StudentdetailsDao studentdetailsDao;

      private final MongoTemplate mongoTemplate;
      public StudentdetailsServiceImpl(StudentdetailsDao  studentdetailsDao,MongoTemplate mongoTemplate) {
          this. studentdetailsDao =  studentdetailsDao;
          this.mongoTemplate=mongoTemplate;
}

    @Override
    public StudentdetailsDto create(StudentdetailsDto studentdetailsDto){
        Studentdetails studentdetails = new Studentdetails();
        BeanUtils.copyProperties(studentdetailsDto, studentdetails);
        Studentdetails createdStudentdetails= studentdetailsDao.create(studentdetails);
        BeanUtils.copyProperties(createdStudentdetails, studentdetailsDto);
        return studentdetailsDto;
    }


    @Override
    public StudentdetailsDto getEntityById(String id) {
    StudentdetailsDto studentdetailsDto = new StudentdetailsDto();
    Optional<Studentdetails> result = studentdetailsDao.getEntityById(id);
        if (result.isPresent()) {
            BeanUtils.copyProperties(result.get(), studentdetailsDto);
        } else {
            throw new EntityNotFoundException("Data not found for ID: " + id);
        }
        return studentdetailsDto;
    }


    @Override
    public List<StudentdetailsDto> getAllValues() {
        List<Studentdetails> studentdetailsEntities = studentdetailsDao.getAllValues();
        List<StudentdetailsDto> studentdetailsDtoList = new ArrayList<>();
        for (Studentdetails studentdetailsEntity : studentdetailsEntities) {
            StudentdetailsDto studentdetailsDto = new StudentdetailsDto();
            BeanUtils.copyProperties(studentdetailsEntity, studentdetailsDto);
            studentdetailsDtoList.add(studentdetailsDto);
        }
        return studentdetailsDtoList;
    }



    @Override
    public StudentdetailsDto update(StudentdetailsDto studentdetailsDto) {
    Optional<Studentdetails> result = studentdetailsDao.update(studentdetailsDto.get_id());
        if (result.isPresent()) {
           Studentdetails studentdetails = result.get();
           BeanUtils.copyProperties(studentdetailsDto, studentdetails);
           studentdetailsDao.create(studentdetails);
           return studentdetailsDto;
        } else {
        throw new EntityNotFoundException("Data not found for update with ID: " + studentdetailsDto.get_id());
        }
    }


    @Override
    public String delete(String id) {
    Optional<Studentdetails> result = studentdetailsDao.getEntityById(id);
        if (result.isPresent()) {
            studentdetailsDao.delete(id);
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