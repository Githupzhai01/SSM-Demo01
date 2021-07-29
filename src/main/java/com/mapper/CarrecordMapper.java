package com.mapper;

import com.domain.Carrecord;
import com.domain.CarrecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarrecordMapper {
    int countByExample(CarrecordExample example);

    int deleteByExample(CarrecordExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Carrecord record);

    int insertSelective(Carrecord record);

    List<Carrecord> selectByExample(CarrecordExample example);

    Carrecord selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Carrecord record, @Param("example") CarrecordExample example);

    int updateByExample(@Param("record") Carrecord record, @Param("example") CarrecordExample example);

    int updateByPrimaryKeySelective(Carrecord record);

    int updateByPrimaryKey(Carrecord record);
}