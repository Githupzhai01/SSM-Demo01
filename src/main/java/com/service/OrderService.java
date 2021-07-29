package com.service;

import com.domain.Orders;
import com.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrdersMapper ordersMapper;

    //查询全部信息
    public List<Orders> selectAll(){
        List<Orders> orders = ordersMapper.selectByExample(null);
        return orders;

    }
}
