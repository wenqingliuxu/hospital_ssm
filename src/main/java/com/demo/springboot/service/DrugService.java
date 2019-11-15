package com.demo.springboot.service;

import com.demo.springboot.pojo.Drug;
import com.demo.springboot.vo.DataGridResult;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/6 10:42
 * @Version 1.0
 */
public interface DrugService {
    public List<Drug> findAllDru();

    public Drug findSigDrug(int drugsId);

    public DataGridResult findAllDruByPage(int page, int pageSize);

    public DataGridResult findAllDruByPage(String title, double price, int page, int pageSize);

    public void insert(Drug drug);

    public void addDrugImage(String imgName, String drName);
}
