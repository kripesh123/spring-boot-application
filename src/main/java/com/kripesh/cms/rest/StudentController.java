package com.kripesh.cms.rest;

import com.kripesh.cms.dao.StudentRepository;
import com.kripesh.cms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/students")
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student s) {
        return repository.save(s);
    }

    @PutMapping("/students")
    public Student getAllStudents(@RequestBody Student s) {
        Optional<Student> student = repository.findById(s.getId());
        if (student.isPresent()) {
            return repository.save(s);
        }
        return null;
    }

    @DeleteMapping("/students")
    public Iterable<Student> deleteById(@RequestParam(value = "id") Long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getById(@PathVariable(value = "id") Long id) {
        return repository.findById(id);
    }
}
