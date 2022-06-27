package com.example.demo.kit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class TimeKit {
    private final String DATA_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private final String DATA_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private TimeKit() {
    }
    public static TimeKit getInstance() {
        return new TimeKit();
    }

    //年月日时分秒 转成 年月日
    public LocalDate transition(LocalDateTime time) {
        return time.toLocalDate();
    }

    //年月日时分秒转字符串
    public String transitionStr(LocalDateTime time) {
        if (null == time) {
            return "";
        } else {
            return time.format(DateTimeFormatter.ofPattern(DATA_FORMAT_YYYY_MM_DD_HH_MM_SS));
        }
    }

    //年月日转字符串
    public String transitionStr(LocalDate time) {
        if (null == time) {
            return "";
        } else {
            return time.format(DateTimeFormatter.ofPattern(DATA_FORMAT_YYYY_MM_DD));
        }
    }
}
