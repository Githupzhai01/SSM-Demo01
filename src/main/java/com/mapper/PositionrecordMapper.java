package com.mapper;

import com.domain.Positionrecord;
import com.domain.PositionrecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionrecordMapper {
    int countByExample(PositionrecordExample example);

    int deleteByExample(PositionrecordExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Positionrecord record);

    int insertSelective(Positionrecord record);

    List<Positionrecord> selectByExample(PositionrecordExample example);

    Positionrecord selectByPrimaryKey(Integer pid);


    int updateByExampleSelective(@Param("record") Positionrecord record, @Param("example") PositionrecordExample example);

    int updateByExample(@Param("record") Positionrecord record, @Param("example") PositionrecordExample example);

    int updateByPrimaryKeySelective(Positionrecord record);

    int updateByPrimaryKey(Positionrecord record);
}