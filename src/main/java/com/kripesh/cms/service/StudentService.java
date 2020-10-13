package com.kripesh.cms.service;

import com.kripesh.cms.entity.Student;

import java.util.Optional;

public interface StudentService {

    Iterable<Student> getAllStudent();

    Student createOrUpdate(Student s);

    Optional<Student> findByStudentId(Long id);

    void deleteById(Long id);

    Student findByEmail(String email);
}
