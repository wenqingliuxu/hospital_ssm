package com.demo.springboot.service;

import com.demo.springboot.pojo.Department;
import com.demo.springboot.pojo.Doctor;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 11:06
 * @Version 1.0
 */
public interface DepartmentService {
    public List<Department> findAllDep();


}
