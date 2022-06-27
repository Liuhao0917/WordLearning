package com.example.demo.service;

import com.example.demo.entity.Student;


public interface StudentService {

    //根据策略字段查询学生信息
    Student queryStudentByStrategyField(String strategyField, String queryField);
}
