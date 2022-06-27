package com.example.demo.dao;

import com.example.demo.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
    // 根据学号删除学生信息
    void deleteByCard(String card);

    // 根据学号查询学生信息
    Student getByCard(String card);

    // 根据名字查询学生信息
    Student getStudentByName(String name);

    //根据手机号查询学生信息
    Student getStudentByPhone(String phone);
}
