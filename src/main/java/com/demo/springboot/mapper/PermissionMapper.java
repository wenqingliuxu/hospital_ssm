package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/7 23:44
 * @Version 1.0
 */
@Mapper
@Repository
public interface PermissionMapper {
    public List<Permission> findPermByLoginName(@Param("doName")String doName);
}
