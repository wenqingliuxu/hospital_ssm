package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.PermissionMapper;
import com.demo.springboot.pojo.Permission;
import com.demo.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/7 23:45
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findPermByLoginName(String doName) {
        List<Permission> permissionList = permissionMapper.findPermByLoginName(doName);
        return permissionList;
    }
}
