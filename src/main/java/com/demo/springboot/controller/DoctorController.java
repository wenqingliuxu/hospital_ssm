package com.demo.springboot.controller;

import com.demo.springboot.pojo.Department;
import com.demo.springboot.pojo.Doctor;
import com.demo.springboot.service.DepartmentService;
import com.demo.springboot.service.DoctorService;
import com.demo.springboot.vo.DoctorVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 10:19
 * @Version 1.0
 */
@Controller
public class DoctorController {
    private final Logger logger = LogManager.getLogger(DoctorController.class);
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/getDoctorByDepartment")
    public String getDoctorsByDep(int deptId, Integer doctorId, String format, Model model) {
        List<Doctor> doctorList = doctorService.getDoctorByDepartment(deptId);
        model.addAttribute("doctorList", doctorList);
        LinkedHashMap<Integer, LinkedHashMap<String, Integer>> linkedHashMap = new LinkedHashMap<Integer, LinkedHashMap<String, Integer>>();
        int docId = 0;
        for (Doctor list1 : doctorList) {
            LinkedHashMap map = new LinkedHashMap();
            String department = list1.getDepartment();
            model.addAttribute("department", department);
            docId = list1.getDoctorId();
            String doName = list1.getDoName();
            model.addAttribute("doName", doName);
            for (int i = 1; i < 8; i++) {
                SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, +i);
                String format1 = date1.format(calendar.getTime());
                Integer count = doctorService.getCountByDate(docId, format1);
                map.put(format1, count);
            }
            linkedHashMap.put(docId, map);
        }
        model.addAttribute("linkedHashMap", linkedHashMap);
        return "doctors";
    }

    @RequestMapping("/showDoctors")
    public String showDoc(Model model) {
        List<Doctor> allDoc = doctorService.findAllDoc();
        model.addAttribute("allDoc", allDoc);
        return "showDoctors";
    }

    @RequestMapping("/singleDoctor")
    public String sigDoc(String doName, Model model) {
        Doctor sigDoc = doctorService.findSigDoc(doName);
        model.addAttribute("sigDoc", sigDoc);
        return "singleDoctor";
    }

    @RequestMapping("/doctorLoginView")
    public String toDoctorLogin() {
        return "doctorLogin";
    }

    @RequestMapping("/doctorRegisterView")
    public String toDocRegister(Model model) {
        List<Department> allDep = departmentService.findAllDep();
        model.addAttribute("allDep", allDep);
        return "doctorRegister";
    }

    @RequestMapping("/docZhuCe")
    public String upload(@RequestParam("file") MultipartFile file, Model model, String code, String userImg, Doctor doctor, HttpSession session) {
        if ((!doctor.getDoName().isEmpty()) && (!doctor.getPwd().isEmpty()) && (!doctor.getDepId().isEmpty()) && (!doctor.getGender().isEmpty()) && (!doctor.getTelphone().isEmpty())
                && (!doctor.getDoInfo().isEmpty())) {
            String doName1 = doctor.getDoName();
            Integer doctorNameCount = doctorService.getdoctorNameCount(doName1);
            if (doctorNameCount == 0) {
                if (((String) session.getAttribute("authCode")).equalsIgnoreCase(code)) {
                    doctorService.doctorZhuCe(doctor);
                    int doctorId = doctor.getDoctorId();
                    String depId = doctor.getDepId();
                    doctorService.addDocDeo(doctorId, depId);
                    String imgName = ("images/" + file.getOriginalFilename());
                    try {
                        file.transferTo(new File("D:/IntellijIDEAworkspace/hospital_ssm/src/main/resources/static/images/" + file.getOriginalFilename()));
                    } catch (IOException e) {
                        logger.error(e);
                    }
                    doctorService.addImage(imgName, doName1);
                    return "doctorLogin";
                } else {
                    model.addAttribute("msf", "验证码错误");
                    return "doctorRegister";
                }
            } else {
                model.addAttribute("msh", "用户名已存在");
                return "doctorRegister";
            }
        } else {
            model.addAttribute("msg", "请输入完整的用户信息");
            return "doctorRegister";

        }
    }

    @RequestMapping(value = "/docDengLu", method = RequestMethod.POST)
    public String doDengLu(DoctorVo doctorVo, String code,Model model, HttpSession session) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(doctorVo.getDoName(), doctorVo.getPwd());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            String doName = doctorVo.getDoName();
//            Doctor doctor = doctorService.findDoctorByLoginName(doName);
            Doctor doctor = doctorService.findSigDoc(doName);
            model.addAttribute("doctor",doctor);
            session.setAttribute("doName",doName);
            if (subject.isAuthenticated() && ((String) session.getAttribute("authCode")).equalsIgnoreCase(code)) {
                if (doctor.getDoStatus() == 3) {
                    return "renzhengzhong";
                } else {
                    return "htindex";
                }
            }
        } catch (AuthenticationException e) {
//                e.printStackTrace();
            logger.error("认证失败");
        }
        return "doctorLogin";

    }

    /*        map.put("/xinneike","perms[heartInfo]");
            map.put("/ganranneike","perms[ganRanInfo]");
            map.put("/erke","perms[childrenInfo]");
            map.put("/shenjingke","perms[shenJingInfo]");
            map.put("/linchuangyingyangke","perms[yingYangInfo]");
            map.put("/myself","perms[singleInfo]");*/
    //    显示主视图
    @RequestMapping(value = "/htindex", method = RequestMethod.GET)
    public String showHtIndex() {
        return "htindex";
    }
    //    显示无权访问
    @RequestMapping("/unauth")
    public String showAuth() {
        return "unauth";
    }
    @RequiresPermissions(value = {"singleInfo"})
    @RequestMapping("/myself")
    public String showMyself() {
        return "myself";
    }
    @RequiresPermissions(value = {"heartInfo"})
    @RequestMapping("/xinneike")
    public String showHeartInfo() {
        return "xinneike";
    }
    @RequiresPermissions(value = {"ganRanInfo"})
    @RequestMapping("/ganranneike")
    public String showGanRanNeiKe() {
        return "ganranneike";
    }
    @RequiresPermissions(value = {"childrenInfo"})
    @RequestMapping("/erke")
    public String toErKe() {
        return "erke";
    }
    @RequiresPermissions(value = {"shenJingInfo"})
    @RequestMapping("/shenjingke")
    public String showShenjingke() {
        return "shenjingke";
    }
    @RequiresPermissions(value = {"yingYangInfo"})
    @RequestMapping("/linchuangyingyangke")
    public String showLinChuang() {
        return "linchuangyingyangke";
    }
    @RequestMapping("/loginOut")
    public String logOut(HttpSession session) {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
//            清除业务会话信息
            session.removeAttribute("doName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:index";
    }
}
