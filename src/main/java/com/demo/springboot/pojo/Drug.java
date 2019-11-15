package com.demo.springboot.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 10:34
 * @Version 1.0
 */
@Data
public class Drug {
    private int drugsId;
    private String drName;
    private Double price;
    private int num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String images;
    private String drInfo;
}
