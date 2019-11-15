package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.DepartmentMapper;
import com.demo.springboot.pojo.Department;
import com.demo.springboot.pojo.Doctor;
import com.demo.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 11:07
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> findAllDep() {
        List<Department> departmentList = departmentMapper.findAllDep();
        return departmentList;
    }


}
