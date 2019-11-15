package com.demo.springboot.service;

import com.demo.springboot.pojo.Doctor;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 16:43
 * @Version 1.0
 */
public interface DoctorService {
    public List<Doctor> getDoctorByDepartment(int depId);

    public Integer getCountByDate(Integer doctorId, String format);

    public List<Doctor> findAllDoc();

    public Doctor findSigDoc(String doName);

    public void doctorZhuCe(Doctor doctor);

    public Integer getdoctorNameCount(String doName);

    public void addImage(String imgName, String doName1);

    public Doctor findDoctorByLoginName(String doName);

    public void addDocDeo(int doctorId, String depId);
}
