package com.kripesh.cms.rest;

import com.kripesh.cms.entity.Student;
import com.kripesh.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> findStudents(){
       List<Student> students = service.findAll();
       return students;
    }

    @GetMapping("/students/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        Student s = service.findById(studentId);
        return s;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> noStudentFound(EmptyResultDataAccessException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Student records were found");
    }
}
