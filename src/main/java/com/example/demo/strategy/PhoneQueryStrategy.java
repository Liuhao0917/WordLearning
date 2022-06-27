package com.example.demo.strategy;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class PhoneQueryStrategy implements QueryStrategy {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student queryByField(String phone) {
        Optional<Student> studentOpt = Optional.ofNullable(studentDao.getStudentByPhone(phone));
        return studentOpt.orElse(null);
    }
}
