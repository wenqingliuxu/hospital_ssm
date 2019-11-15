package com.demo.springboot.service;

import com.demo.springboot.pojo.Patient;

/**
 * @Author: 刘旭
 * Date: 2019/11/6 19:15
 * @Version 1.0
 */
public interface PatientService {
    public Patient getPatientByPaName(String paName);

    public Integer getPatientNameCount(String paName);

    public void yuYue(String yonghuName, String dateNow, int doctorId);

    public Patient getSigPatient(String yonghuName);

    public Patient getSigPatientInfo(String paName);

    public void register(Patient patient);

    public void delYuYue(String paName);
}
