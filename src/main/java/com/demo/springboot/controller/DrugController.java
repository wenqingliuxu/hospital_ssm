package com.demo.springboot.controller;

import com.demo.springboot.pojo.Drug;
import com.demo.springboot.service.DrugService;
import com.demo.springboot.vo.DataGridResult;
import com.demo.springboot.vo.MsgResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/11/6 10:38
 * @Version 1.0
 */
@Controller
public class DrugController {
    private final Logger logger=LogManager.getLogger(DrugController.class);
    @Autowired
    @Qualifier(value = "drugService")
    private com.demo.springboot.service.DrugService drugService;
    @RequestMapping("/showDrugs")
    public String showDrugs(Model model){
        List<Drug> drugList = drugService.findAllDru();
        model.addAttribute("drugList",drugList);
        return "showDrugs";
    }
    @RequestMapping("/singleDrug")
    public String showSigDrug(int drugsId,Model model){
        Drug sigDrug = drugService.findSigDrug(drugsId);
        model.addAttribute("sigDrug",sigDrug);
        return "singleDrug";
    }
    @RequestMapping(value = "/drugsGuanLi",method = RequestMethod.GET)
    public String showDrugsGuanLi(){
        return "drugsguanli";
    }
    @RequestMapping(value = "/drugsGuanLia",method = RequestMethod.POST)
    @ResponseBody
    public DataGridResult drugsGuanLi(@RequestParam(value = "title",defaultValue = "") String title,
                                      @RequestParam(value = "price",defaultValue = "100000.0") double price,
                                      @RequestParam(value = "page",defaultValue = "1") int page,
                                      @RequestParam(value = "rows",defaultValue = "10") int pageSize ){
        DataGridResult drugList = drugService.findAllDruByPage(title,price,page,pageSize);
        return drugList;
    }
    @RequestMapping("/drugAdd")
    public String showDrugAdd(){
        return "drug_add";
    }
    @RequestMapping(value = "drugAdda",method = RequestMethod.POST)
    @ResponseBody
    public MsgResult addDrug(@RequestParam("file") MultipartFile file, Drug drug, String img){
        logger.info("=========="+drug);
//        调用业务方法写入数据库
        drugService.insert(drug);
        String drName = drug.getDrName();
        String imgName = ("images/" + file.getOriginalFilename());
        try {
            file.transferTo(new File("D:/IntellijIDEAworkspace/hospital_ssm/src/main/resources/static/images/" + file.getOriginalFilename()));
        } catch (IOException e) {
            logger.error(e);
        }
        drugService.addDrugImage(imgName, drName);
        MsgResult result = new MsgResult(200, "success", null);
        return result;
    }
}
