package com.geppetto.demoappjava.service;

import com.geppetto.demoappjava.dto.StudentmarksDto;
import java.util.List;
import java.util.Map;

public interface StudentmarksService {

    StudentmarksDto create(StudentmarksDto studentmarksDto);


    StudentmarksDto getEntityById(String id);


    List<StudentmarksDto> getAllValues();


    StudentmarksDto update(StudentmarksDto studentmarksDto);


    String delete(String id);



}
