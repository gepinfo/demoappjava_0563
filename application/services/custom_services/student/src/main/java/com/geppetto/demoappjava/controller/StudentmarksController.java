package com.geppetto.demoappjava.controller;

import com.geppetto.demoappjava.dto.StudentmarksDto;
import com.geppetto.demoappjava.service.StudentmarksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;


@RestController
@RequestMapping("/studentmarks")
public class StudentmarksController {

   private final StudentmarksService studentmarksService;

   public StudentmarksController(StudentmarksService studentmarksService) {
      this.studentmarksService = studentmarksService;
   }

    @PostMapping
    public ResponseEntity<StudentmarksDto> create(@RequestBody StudentmarksDto studentmarksDto) {
      return ResponseEntity.status(HttpStatus.OK).body(studentmarksService.create(studentmarksDto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentmarksDto> getEntityById(@PathVariable String id) {
       return ResponseEntity.ok(studentmarksService.getEntityById(id));
    }


    @GetMapping
     public ResponseEntity<List<StudentmarksDto>> getAllValues() {
       return ResponseEntity.ok(studentmarksService.getAllValues());
     }


    @PutMapping
    public ResponseEntity<StudentmarksDto> update(@RequestBody StudentmarksDto studentmarksDto) {
       return ResponseEntity.ok(studentmarksService.update(studentmarksDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
       return ResponseEntity.ok(studentmarksService.delete(id));
    }



}