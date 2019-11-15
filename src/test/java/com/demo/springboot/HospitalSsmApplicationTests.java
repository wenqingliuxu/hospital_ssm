package com.demo.springboot;

import com.demo.springboot.mapper.DepartmentMapper;
import com.demo.springboot.pojo.Department;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalSsmApplicationTests {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Test
    public void findDepTest() {
        List<Department> allDep = departmentMapper.findAllDep();
        System.out.println(allDep.toString());
    }

}
