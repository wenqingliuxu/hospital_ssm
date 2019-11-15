package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: 刘旭
 * Date: 2019/11/6 19:16
 * @Version 1.0
 */
@Mapper
@Repository
public interface PatientMapper {
    public Patient getPatientByPaName(String paName);
    public Integer getPatientNameCount(String paName);
    public void yuYue(String yonghuName, String dateNow, int doctorId);
    public Patient getSigPatient(String yonghuName);
    public Patient getSigPatientInfo(String paName);
    public void register(Patient patient);
    public void delYuYue(String paName);

}
