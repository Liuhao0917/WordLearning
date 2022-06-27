package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.strategy.QueryStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private static String STRATEGY_NAME = "%sQueryStrategy";

    @Autowired
    private Map<String, QueryStrategy> queryStrategyMap;

    @Override
    public Student queryStudentByStrategyField(String strategyField, String queryField) {
        String realStrategyName = String.format(STRATEGY_NAME, strategyField);
        QueryStrategy queryStrategy = queryStrategyMap.get(realStrategyName);
        return queryStrategy.queryByField(queryField);
    }
}
