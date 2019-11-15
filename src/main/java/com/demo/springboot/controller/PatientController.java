package com.demo.springboot.controller;

import com.demo.springboot.pojo.Department;
import com.demo.springboot.pojo.Patient;
import com.demo.springboot.service.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import javax.security.auth.Subject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 10:01
 * @Version 1.0
 */
@Controller
//@SessionAttributes("yonghuName")
public class PatientController {
    private final Logger logger= LogManager.getLogger(PatientController.class);
    @Autowired
    private PatientService patientService;

    @RequestMapping("login")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/dengLu")
    public String denglu(Patient patient, String code, Model model, HttpSession session) {
        String yonghuName=patient.getPaName();
        model.addAttribute("yonghuName", yonghuName);
        if (!patient.getPaName().isEmpty()) {
            String upwd = patient.getPassword();
            Patient patientReb = patientService.getPatientByPaName(patient.getPaName());
            Integer patientNameCount = patientService.getPatientNameCount(patient.getPaName());
            if (patientNameCount == 0) {
                model.addAttribute("msg", "提示：用户名或密码错误");
                return "login";
            }else {
                if (upwd.equals(patientReb.getPassword())) {
                    if (!((String) session.getAttribute("authCode")).equalsIgnoreCase(code)) {
                        model.addAttribute("msn", "提示：验证码错误");
                        return "login";
                    }else {
                        session.setAttribute("yonghuName",yonghuName);
                        return "redirect:appointment";
                    }
                } else {
                    model.addAttribute("msg", "提示：用户名或密码错误");
                    return "login";
                }
            }
        } else {
            model.addAttribute("msg", "提示：用户名不能为空");
            return "login";
        }
    }

    @RequestMapping("/yuYue")
    public String yuYue(int doctorId, String date,String paName,HttpSession session,Model model){
        String yonghuName = (String) session.getAttribute("yonghuName");
        if (yonghuName!=null) {
            patientService.yuYue(yonghuName, date, doctorId);
            Patient sigPatient = patientService.getSigPatient(yonghuName);
            model.addAttribute("sigPatient",sigPatient);
//            session.removeAttribute("yonghuName");
            return "redirect:singlePatient";
        }else {
            return "login";
        }
    }
    @RequestMapping("/delYuYue")
    public String delYuYue(String paName){
        patientService.delYuYue(paName);
        return "redirect:singlePatient";
    }
    @RequestMapping("/singlePatient")
    public String showSigPatient(String paName,HttpSession session,Model model){
        String yonghuName = (String) session.getAttribute("yonghuName");
        if (yonghuName!=null) {
            Patient sigPatient = patientService.getSigPatient(yonghuName);
            int doctorId1 = sigPatient.getDoctorId();
            Patient sigPatientInfo = patientService.getSigPatientInfo(yonghuName);
            model.addAttribute("sigPatientInfo",sigPatientInfo);
            return "singlePatient";
        }else {
            return "login";
        }
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("yonghuName");
        return "redirect:index";
    }
    //注册
    @RequestMapping("/register")
    public String showRegister(){
        return "register";
    }
    @RequestMapping("/zhuCe")
    public String toZhuCe(Patient patient,String code,Model model,HttpSession session){
        if((!patient.getPaName().isEmpty())&&(!patient.getPassword().isEmpty())&&(!patient.getAge().isEmpty())&&(!patient.getGender().isEmpty())&&(!patient.getTel().isEmpty())){
            Integer patientNameCount = patientService.getPatientNameCount(patient.getPaName());
            if(patientNameCount==0){
                if(((String) session.getAttribute("authCode")).equalsIgnoreCase(code)){
                    patientService.register(patient);
                    return "login";
                }else{
                    model.addAttribute("msf","验证码错误");
                    return "register";
                }
            }else{
                model.addAttribute("msh","用户名已存在");
                return "register";
            }
        }else {
            model.addAttribute("msg","请输入完整的用户信息");
            return "register";
        }
    }
//    验证码
    private char[] codeSequence = {'A', '1', 'B', 'C', '2', 'D', '3', 'E', '4', 'F', '5', 'G', '6', 'H', '7', 'I', '8', 'J',
            'K', '9', 'L', '1', 'M', '2', 'N', 'P', '3', 'Q', '4', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'};

    @RequestMapping("/code")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        int width = 70;
        int height =37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getColor(200, 250));
        g.setFont(new Font("Times New Roman", 0, 28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for (int i = 0; i < 40; i++) {
            g.setColor(this.getColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            strCode = strCode + rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("authCode", strCode.toLowerCase());
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();
    }

    public Color getColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
