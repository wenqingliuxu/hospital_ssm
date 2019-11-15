package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.DrugMapper;
import com.demo.springboot.pojo.Drug;
import com.demo.springboot.pojo.DrugExample;
import com.demo.springboot.service.DrugService;
import com.demo.springboot.vo.DataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/6 10:43
 * @Version 1.0
 */
@Service(value = "drugService")
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

     @Override
    public List<Drug> findAllDru() {
        List<Drug> allDru = drugMapper.findAllDru();
        return allDru;
    }

    @Override
    public Drug findSigDrug(int drugsId) {
        Drug sigDrug = drugMapper.findSigDrug(drugsId);
        return sigDrug;
    }

    @Override
    public DataGridResult findAllDruByPage(int page, int pageSize) {
        DataGridResult gridResult = new DataGridResult();
        DrugExample drugExample = new DrugExample();
        PageHelper.startPage(page, pageSize);//拦截查询语句，并添加分页特征
        List<Drug> allDru = drugMapper.selectByExample(drugExample);
        PageInfo pageInfo = new PageInfo(allDru);//获取结果集分页信息
        long total = pageInfo.getTotal();//获取总分页数
        gridResult.setRows(allDru);
        gridResult.setTotal(total);
        return gridResult;
    }

    @Override
    public DataGridResult findAllDruByPage(String title, double price, int page, int pageSize) {
        DataGridResult gridResult = new DataGridResult();
        DrugExample drugExample = new DrugExample();
        //        创建条件查询对象
        DrugExample.Criteria criteria = drugExample.createCriteria();
        if(!StringUtils.isEmpty(title)){
            criteria.andDrInfoLike("%"+title+"%");
        }
//        添加price查询条件
            criteria.andPriceLessThanOrEqualTo(price);
        PageHelper.startPage(page, pageSize);//拦截查询语句，并添加分页特征
        List<Drug> allDru = drugMapper.selectByExample(drugExample);
        PageInfo pageInfo = new PageInfo(allDru);//获取结果集分页信息
        long total = pageInfo.getTotal();//获取总分页数
        gridResult.setRows(allDru);
        gridResult.setTotal(total);
        return gridResult;
    }

    @Override
    public void insert(Drug drug) {
        drugMapper.insert(drug);
    }

    @Override
    public void addDrugImage(String imgName, String drName) {
        drugMapper.addDrugImgage(imgName,drName);
    }

}
