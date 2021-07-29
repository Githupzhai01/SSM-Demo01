package com.controller;

import com.domain.Orders;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    //查询所有
    @RequestMapping(value = "/selAll")
    public String selectTbl2() {
        List<Orders> orders = orderService.selectAll();
        for (Orders orders1 : orders) {
            System.out.println(orders1);
        }
        return "index";
    }


}
