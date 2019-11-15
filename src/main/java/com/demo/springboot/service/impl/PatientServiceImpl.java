package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.PatientMapper;
import com.demo.springboot.pojo.Patient;
import com.demo.springboot.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘旭
 * Date: 2019/11/6 19:15
 * @Version 1.0
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Patient getPatientByPaName(String paName) {
        Patient patient = patientMapper.getPatientByPaName(paName);
        return patient;
    }

    @Override
    public Integer getPatientNameCount(String paName) {
        Integer count = patientMapper.getPatientNameCount(paName);
        return count;
    }

    @Override
    public void yuYue(String yonghuName, String dateNow, int doctorId) {
        patientMapper.yuYue(yonghuName,dateNow,doctorId);
    }

    @Override
    public Patient getSigPatient(String yonghuName) {
        Patient sigPatient = patientMapper.getSigPatient(yonghuName);
        return sigPatient;
    }

    @Override
    public Patient getSigPatientInfo(String paName) {
        return patientMapper.getSigPatientInfo(paName);
    }

    @Override
    public void register(Patient patient) {
        patientMapper.register(patient);
    }

    @Override
    public void delYuYue(String paName) {
        patientMapper.delYuYue(paName);
    }
}
