package com.example.demo.strategy;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NameQueryStrategy implements QueryStrategy {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student queryByField(String name) {
        Optional<Student> studentOpt = Optional.ofNullable(studentDao.getStudentByName(name));
        return studentOpt.orElse(null);
    }
}
