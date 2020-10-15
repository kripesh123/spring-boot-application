package com.kripesh.cms.service;

import com.kripesh.cms.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();
    Student findById(Long id);

}
