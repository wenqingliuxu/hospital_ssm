package com.demo.springboot.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 10:37
 * @Version 1.0
 */
@Data
public class Patient {
    private int patientId;
    private String paName;
    private String age;
    private String gender;
    private int paStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String tel;
    private String doName;
    private String password;
    private int doctorId;
    private String telphone;
    private String images;
    private String doInfo;
}
