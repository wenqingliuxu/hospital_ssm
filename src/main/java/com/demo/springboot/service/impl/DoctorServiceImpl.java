package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.DoctorMapper;
import com.demo.springboot.pojo.Doctor;
import com.demo.springboot.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 16:43
 * @Version 1.0
 */
@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public List<Doctor> getDoctorByDepartment(int depId) {
        List<Doctor> doctorList = doctorMapper.getDoctorByDepartment(depId);
        return doctorList;
    }

    @Override
    public Integer getCountByDate(Integer doctorId, String format) {
        Integer count = doctorMapper.getCountByDate(doctorId,format);
        return count;
    }

    @Override
    public List<Doctor> findAllDoc() {
        List<Doctor> alldoctorList = doctorMapper.findAllDoc();
        return alldoctorList;
    }

    @Override
    public Doctor findSigDoc(String doName) {
        Doctor sigDoc = doctorMapper.findSigDoc(doName);
        return sigDoc;
    }

    @Override
    public void doctorZhuCe(Doctor doctor) {
        doctorMapper.doctorZhuCe(doctor);
    }

    @Override
    public Integer getdoctorNameCount(String doName) {
        Integer count = doctorMapper.getdoctorNameCount(doName);
        return count;
    }

    @Override
    public void addImage(String imgName, String doName1) {
        doctorMapper.addImage(imgName,doName1);
    }

    @Override
    public Doctor findDoctorByLoginName(String doName) {
        Doctor doctor = doctorMapper.findDoctorByLoginName(doName);
        return doctor;
    }

    @Override
    public void addDocDeo(int doctorId, String depId) {
        doctorMapper.addDocDeo(doctorId,depId);
    }
}
