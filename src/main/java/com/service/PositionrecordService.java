package com.service;

import com.domain.Positionrecord;
import com.domain.PositionrecordExample;
import com.mapper.PositionrecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionrecordService {
    @Autowired
    PositionrecordMapper positionrecordMapper;

    //查询部门信息
    public List<Positionrecord> SelectName(){
        PositionrecordExample positionrecordExample = new PositionrecordExample();
        positionrecordExample.createCriteria().andPositionstateEqualTo(1);
        List<Positionrecord> positionrecords = positionrecordMapper.selectByExample(positionrecordExample);
        return positionrecords;

    }

    //更改车位信息
    public void updCar(Positionrecord positionrecord){
        positionrecordMapper.updateByPrimaryKeySelective(positionrecord);
    }

}
