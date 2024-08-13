package com.geppetto.demoappjava.controller;

import com.geppetto.demoappjava.dto.StduentrankDto;
import com.geppetto.demoappjava.service.StduentrankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;


@RestController
@RequestMapping("/stduentrank")
public class StduentrankController {

   private final StduentrankService stduentrankService;

   public StduentrankController(StduentrankService stduentrankService) {
      this.stduentrankService = stduentrankService;
   }

    @PostMapping
    public ResponseEntity<StduentrankDto> create(@RequestBody StduentrankDto stduentrankDto) {
      return ResponseEntity.status(HttpStatus.OK).body(stduentrankService.create(stduentrankDto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<StduentrankDto> getEntityById(@PathVariable String id) {
       return ResponseEntity.ok(stduentrankService.getEntityById(id));
    }


    @GetMapping
     public ResponseEntity<List<StduentrankDto>> getAllValues() {
       return ResponseEntity.ok(stduentrankService.getAllValues());
     }


    @PutMapping
    public ResponseEntity<StduentrankDto> update(@RequestBody StduentrankDto stduentrankDto) {
       return ResponseEntity.ok(stduentrankService.update(stduentrankDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
       return ResponseEntity.ok(stduentrankService.delete(id));
    }



}