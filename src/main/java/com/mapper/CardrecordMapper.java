package com.mapper;

import com.domain.Cardrecord;
import com.domain.CardrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardrecordMapper {
    int countByExample(CardrecordExample example);

    int deleteByExample(CardrecordExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Cardrecord record);

    int insertSelective(Cardrecord record);

    List<Cardrecord> selectByExample(CardrecordExample example);

    Cardrecord selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Cardrecord record, @Param("example") CardrecordExample example);

    int updateByExample(@Param("record") Cardrecord record, @Param("example") CardrecordExample example);

    int updateByPrimaryKeySelective(Cardrecord record);

    int updateByPrimaryKey(Cardrecord record);
}