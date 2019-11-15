package com.demo.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/9 16:32
 * @Version 1.0
 */
//封装一个送给前端的相应对象
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgResult {
    private int statusCode;//响应状态码
    private String message;//相应短消息
    private List<?> data;//相应携带的数据
}
