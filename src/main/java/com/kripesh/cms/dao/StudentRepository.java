package com.kripesh.cms.dao;

import com.kripesh.cms.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findById(long id);
    List<Student> findByLastName(String lastName);


}
