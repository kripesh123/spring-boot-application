package com.kripesh.cms.service;

import com.kripesh.cms.entity.Student;
import com.kripesh.cms.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM students";

        return template.query(sql, new StudentMapper());
    }

    @Override
    public Student findById(Long id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        return template.queryForObject(sql, new Object[]{id}, new StudentMapper());
    }
}
