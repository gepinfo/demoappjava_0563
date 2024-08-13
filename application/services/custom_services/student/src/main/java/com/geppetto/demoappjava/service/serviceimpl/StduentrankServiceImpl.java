package com.geppetto.demoappjava.service.serviceimpl;

import com.geppetto.demoappjava.dao.StduentrankDao;
import com.geppetto.demoappjava.model.Stduentrank;
import com.geppetto.demoappjava.dto.StduentrankDto;
import com.geppetto.demoappjava.service.StduentrankService;
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
public class StduentrankServiceImpl implements StduentrankService{

      private final StduentrankDao stduentrankDao;

      private final MongoTemplate mongoTemplate;
      public StduentrankServiceImpl(StduentrankDao  stduentrankDao,MongoTemplate mongoTemplate) {
          this. stduentrankDao =  stduentrankDao;
          this.mongoTemplate=mongoTemplate;
}

    @Override
    public StduentrankDto create(StduentrankDto stduentrankDto){
        Stduentrank stduentrank = new Stduentrank();
        BeanUtils.copyProperties(stduentrankDto, stduentrank);
        Stduentrank createdStduentrank= stduentrankDao.create(stduentrank);
        BeanUtils.copyProperties(createdStduentrank, stduentrankDto);
        return stduentrankDto;
    }


    @Override
    public StduentrankDto getEntityById(String id) {
    StduentrankDto stduentrankDto = new StduentrankDto();
    Optional<Stduentrank> result = stduentrankDao.getEntityById(id);
        if (result.isPresent()) {
            BeanUtils.copyProperties(result.get(), stduentrankDto);
        } else {
            throw new EntityNotFoundException("Data not found for ID: " + id);
        }
        return stduentrankDto;
    }


    @Override
    public List<StduentrankDto> getAllValues() {
        List<Stduentrank> stduentrankEntities = stduentrankDao.getAllValues();
        List<StduentrankDto> stduentrankDtoList = new ArrayList<>();
        for (Stduentrank stduentrankEntity : stduentrankEntities) {
            StduentrankDto stduentrankDto = new StduentrankDto();
            BeanUtils.copyProperties(stduentrankEntity, stduentrankDto);
            stduentrankDtoList.add(stduentrankDto);
        }
        return stduentrankDtoList;
    }



    @Override
    public StduentrankDto update(StduentrankDto stduentrankDto) {
    Optional<Stduentrank> result = stduentrankDao.update(stduentrankDto.get_id());
        if (result.isPresent()) {
           Stduentrank stduentrank = result.get();
           BeanUtils.copyProperties(stduentrankDto, stduentrank);
           stduentrankDao.create(stduentrank);
           return stduentrankDto;
        } else {
        throw new EntityNotFoundException("Data not found for update with ID: " + stduentrankDto.get_id());
        }
    }


    @Override
    public String delete(String id) {
    Optional<Stduentrank> result = stduentrankDao.getEntityById(id);
        if (result.isPresent()) {
            stduentrankDao.delete(id);
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