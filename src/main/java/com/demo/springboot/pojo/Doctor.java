package com.demo.springboot.pojo;

import lombok.Data;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 10:30
 * @Version 1.0
 */
@Data
public class Doctor {
    private int doctorId;
    private String doName;
    private String gender;
    private String department;
    private int doStatus;
    private String telphone;
    private String images;
    private String depId;
    private String doInfo;
    private String pwd;
}
