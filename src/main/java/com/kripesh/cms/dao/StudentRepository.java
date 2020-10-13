package com.kripesh.cms.dao;

import com.kripesh.cms.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findById(long id);
    List<Student> findByLastName(String lastName);

    Student findByEmailAddress(String emailAddress);

    @Query("select s from Student s where s.firstName like %?1")
    List<Student> findByNameEndsWith(String chars);


}
