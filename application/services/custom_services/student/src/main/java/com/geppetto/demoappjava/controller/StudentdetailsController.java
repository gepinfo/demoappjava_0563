package com.geppetto.demoappjava.controller;

import com.geppetto.demoappjava.dto.StudentdetailsDto;
import com.geppetto.demoappjava.service.StudentdetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;


@RestController
@RequestMapping("/studentdetails")
public class StudentdetailsController {

   private final StudentdetailsService studentdetailsService;

   public StudentdetailsController(StudentdetailsService studentdetailsService) {
      this.studentdetailsService = studentdetailsService;
   }

    @PostMapping
    public ResponseEntity<StudentdetailsDto> create(@RequestBody StudentdetailsDto studentdetailsDto) {
      return ResponseEntity.status(HttpStatus.OK).body(studentdetailsService.create(studentdetailsDto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentdetailsDto> getEntityById(@PathVariable String id) {
       return ResponseEntity.ok(studentdetailsService.getEntityById(id));
    }


    @GetMapping
     public ResponseEntity<List<StudentdetailsDto>> getAllValues() {
       return ResponseEntity.ok(studentdetailsService.getAllValues());
     }


    @PutMapping
    public ResponseEntity<StudentdetailsDto> update(@RequestBody StudentdetailsDto studentdetailsDto) {
       return ResponseEntity.ok(studentdetailsService.update(studentdetailsDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
       return ResponseEntity.ok(studentdetailsService.delete(id));
    }



}