package com.example.demo.controller;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Api(tags = "学生信息")
@Controller
public class StudentController {
    @Autowired
    StudentDao studentDao;
    @Autowired
    private StudentService studentService;

    // 跳转至学生注册页面
    @GetMapping("/sregister")
    public String register() {
        return "sregister";
    }

    // 实现学生注册
    @ApiOperation(value = "注册")
    @ResponseBody
    @PostMapping("/Sregister")
    public Student Register(@RequestBody Student student) {
        if (studentDao.getByCard(student.getCard()) == null && student.getCard() != "") {
            studentDao.save(student);
            return student;
        }
        return null;
    }

    // 跳转至修改学生信息页面
    @GetMapping("/update")
    public String update() {
        return "update";
    }

    //修改学生信息
    @ApiOperation(value = "修改")
    @ResponseBody
    @PostMapping("/Supdate")
    public Student Update(@RequestBody Student student) {
        Student newStudent = studentDao.getByCard(student.getCard());
        if (newStudent != null) {
            newStudent.setName(student.getName());
            newStudent.setSex(student.getSex());
            newStudent.setPhone(student.getPhone());
            studentDao.save(newStudent);
            return newStudent;
        }
        return null;
    }

    // 跳转至删除学生页面
    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    //删除学生
    @ApiOperation(value = "删除")
    @Transactional
    @PostMapping("/Delete")
    public void Delete(String card) {
        studentDao.deleteByCard(card);
    }


    // 快捷删除学生
    @ApiOperation(value = "删除")
    @Transactional
    @GetMapping("/Delete/{card}")
    public String delete(@PathVariable("card") String card) {
        studentDao.deleteByCard(card);
        return "redirect:/message";
    }

    //跳转至搜索学生页面
    @GetMapping("/retrieve")
    public String retrieve() {
        return "retrieve";
    }

    //查询学生信息
    @ResponseBody
    @ApiOperation("根据策略查询学生信息")
    @GetMapping("queryStudent/{strategy}/{field}")
    public Student queryStudentByStrategy(@PathVariable String strategy,
                                          @PathVariable String field) {
        return this.studentService.queryStudentByStrategyField(strategy, field);
    }
}

