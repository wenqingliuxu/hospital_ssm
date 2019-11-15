package com.demo.springboot.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/9 10:37
 * @Version 1.0
 */
@Data
public class DataGridResult {
    private long total;//总记录数
    private List<?> rows;//当前页的结果集
}
