package com.kripesh.cms.mapper;

import com.kripesh.cms.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Student(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("email"));
    }
}
