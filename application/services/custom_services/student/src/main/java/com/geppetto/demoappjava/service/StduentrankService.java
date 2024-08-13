package com.geppetto.demoappjava.service;

import com.geppetto.demoappjava.dto.StduentrankDto;
import java.util.List;
import java.util.Map;

public interface StduentrankService {

    StduentrankDto create(StduentrankDto stduentrankDto);


    StduentrankDto getEntityById(String id);


    List<StduentrankDto> getAllValues();


    StduentrankDto update(StduentrankDto stduentrankDto);


    String delete(String id);



}
