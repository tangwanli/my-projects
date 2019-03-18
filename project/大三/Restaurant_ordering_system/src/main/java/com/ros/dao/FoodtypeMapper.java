package com.ros.dao;

import com.ros.bean.Foodtype;
import com.ros.bean.FoodtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodtypeMapper {
    long countByExample(FoodtypeExample example);

    int deleteByExample(FoodtypeExample example);

    int deleteByPrimaryKey(Integer foodtypeId);

    int insert(Foodtype record);

    int insertSelective(Foodtype record);

    List<Foodtype> selectByExample(FoodtypeExample example);

    Foodtype selectByPrimaryKey(Integer foodtypeId);

    int updateByExampleSelective(@Param("record") Foodtype record, @Param("example") FoodtypeExample example);

    int updateByExample(@Param("record") Foodtype record, @Param("example") FoodtypeExample example);

    int updateByPrimaryKeySelective(Foodtype record);

    int updateByPrimaryKey(Foodtype record);
}