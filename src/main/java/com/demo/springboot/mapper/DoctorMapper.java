package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/2 16:42
 * @Version 1.0
 */
@Mapper
@Repository
public interface DoctorMapper {
    public List<Doctor> getDoctorByDepartment(int depId);
    public Integer getCountByDate(Integer doctorId, String format1);
    public List<Doctor> findAllDoc();
    public Doctor findSigDoc(String doName);
    public void doctorZhuCe(Doctor doctor);
    public Integer getdoctorNameCount(String doName);
    public void addImage(String imgName, String doName1);
    public Doctor findDoctorByLoginName(@Param("doName") String doName);
    public void addDocDeo(int doctorId, String depId);
}
