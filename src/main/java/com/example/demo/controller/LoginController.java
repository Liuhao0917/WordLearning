package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.kit.TimeKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

// 登录界面
@Controller
@Api(tags = "登录界面")
public class LoginController {

    @Autowired
    UserDao userDao;

    // 跳转至系统主界面
    @GetMapping("/")
    public String Login() {
        return "login";
    }

    //登录
    @ApiOperation(value = "登录")
    @PostMapping("doLogin")
    public String doLogin(String userName, String password, HttpSession httpSession, Model model) {
        User u = userDao.getByUserName(userName);
        if (u != null && u.getPassword().equals(password)) {
            httpSession.setAttribute("currentuser", u);
            httpSession.setAttribute("systemTime",getSystemTime());
            return "notifications";
        } else {
            model.addAttribute("error","用户名或密码输入错误，登陆失败");
            return null;
        }

    }

    // 获取系统时间
    private String getSystemTime() {
        LocalDate now = LocalDate.now();
        TimeKit timeKit = TimeKit.getInstance();
        return timeKit.transitionStr(now);
    }

    // 管理员注册
    @ApiOperation(value = "注册")
    @GetMapping("register")
    public String register() {
        return "register";
    }


}
