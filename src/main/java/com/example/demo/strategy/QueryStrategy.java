package com.example.demo.strategy;

import com.example.demo.entity.Student;

import java.util.List;

public interface QueryStrategy {

    Student queryByField(String field);
}
