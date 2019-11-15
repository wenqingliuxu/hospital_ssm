package com.demo.springboot.service;

import com.demo.springboot.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/7 23:42
 * @Version 1.0
 */
public interface PermissionService {
    public List<Permission> findPermByLoginName(String doName);
}
