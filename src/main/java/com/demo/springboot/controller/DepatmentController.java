package com.demo.springboot.controller;

import com.demo.springboot.pojo.Department;
import com.demo.springboot.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 11:08
 * @Version 1.0
 */
@Controller
public class DepatmentController {
    private final Logger logger= LogManager.getLogger(DepatmentController.class);
    @Autowired
    private DepartmentService departmentService;

   @RequestMapping("main")
   public String showMain(){
       return "main";
   }
    @RequestMapping("/appointment")
    public String showDep(Model model){
        List<Department> allDep = departmentService.findAllDep();
        model.addAttribute("allDep",allDep);
        return "appointment";
    }

}
