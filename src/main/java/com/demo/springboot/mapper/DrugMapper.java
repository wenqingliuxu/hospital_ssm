package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Drug;
import com.demo.springboot.pojo.DrugExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DrugMapper {
	public List<Drug> findAllDru();
    public Drug findSigDrug(int drugsId);
    public List<Drug> findAllDruByPage(int page, int pageSize);
    int countByExample(DrugExample example);

    int deleteByExample(DrugExample example);

    int deleteByPrimaryKey(Integer drugsId);

    int insert(Drug record);

    int insertSelective(Drug record);

    List<Drug> selectByExample(DrugExample example);

    Drug selectByPrimaryKey(Integer drugsId);

    int updateByExampleSelective(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByExample(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);

    public void addDrugImgage(String imgName, String drName);
}