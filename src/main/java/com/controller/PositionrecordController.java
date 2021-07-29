package com.controller;

import com.domain.Msg;
import com.domain.Positionrecord;
import com.service.PositionrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class PositionrecordController {
    @Autowired
    PositionrecordService positionrecordService;

    //查询部门信息
    @RequestMapping("depts")
    @ResponseBody
    public Msg selectName(){
        List<Positionrecord> tblDepts = positionrecordService.SelectName();
        Msg msg=new Msg();
        return msg.success().add("depts",tblDepts);
    }

    @RequestMapping(value = "/updcar")
    public Msg updCar(Positionrecord positionrecord){
        positionrecordService.updCar(positionrecord);
        return Msg.success();
    }
}
