package com.service;

import com.domain.Carrecord;
import com.mapper.CarrecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    CarrecordMapper carrecordMapper;

    public void stopcar(Carrecord carrecord) {
        carrecord.setCarstate(0);
        carrecord.setCarstatedes("停车中");
        carrecordMapper.insertSelective(carrecord);
    }
}
