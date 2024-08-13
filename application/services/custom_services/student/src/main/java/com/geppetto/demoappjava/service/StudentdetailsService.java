package com.geppetto.demoappjava.service;

import com.geppetto.demoappjava.dto.StudentdetailsDto;
import java.util.List;
import java.util.Map;

public interface StudentdetailsService {

    StudentdetailsDto create(StudentdetailsDto studentdetailsDto);


    StudentdetailsDto getEntityById(String id);


    List<StudentdetailsDto> getAllValues();


    StudentdetailsDto update(StudentdetailsDto studentdetailsDto);


    String delete(String id);



}
