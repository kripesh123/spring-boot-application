package com.kripesh.cms.rest;

import com.kripesh.cms.dao.StudentRepository;
import com.kripesh.cms.entity.Student;
import com.kripesh.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Iterable<Student> getAll() {
        return studentService.getAllStudent();
    }

    @PostMapping
    public Student save(@RequestBody Student s) {
        return studentService.createOrUpdate(s);
    }

    @PutMapping
    public Student update(@RequestBody Student s) {
        return studentService.createOrUpdate(s);
    }

    @DeleteMapping
    public Iterable<Student> deleteById(@RequestParam(value = "id") Long id) {
        studentService.deleteById(id);
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable(value = "id") Long id) {
        return studentService.findByStudentId(id);
    }

    @GetMapping("/email")
    public Student getByEmail(@RequestParam(value = "email") String email){
        Student s = studentService.findByEmail(email);
        return s;
    }
}
