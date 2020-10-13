package com.kripesh.cms.service;

import com.kripesh.cms.dao.StudentRepository;
import com.kripesh.cms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Iterable<Student> getAllStudent() {
         Iterable<Student> students = repository.findAll();
         return students;
    }

    @Override
    public Student createOrUpdate(Student s) {
        if (s.getId() != null){
            Optional<Student> student = findByStudentId(s.getId());
            if(student.isPresent()){
                return save(s);
            }
        }
        return save(s);
    }

    private Student save(Student s) {
        return repository.save(s);
    }

    @Override
    public Optional<Student> findByStudentId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmailAddress(email);
    }
}
