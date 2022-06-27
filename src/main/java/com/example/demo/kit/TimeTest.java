package com.example.demo.kit;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class TimeTest {

    public static void main(String[] args) {
        TimeKit timeKit = TimeKit.getInstance();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDate transition = timeKit.transition(now);
        System.out.println("transition = " + transition);
    }
}
