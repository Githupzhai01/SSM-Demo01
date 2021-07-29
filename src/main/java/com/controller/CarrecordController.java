package com.controller;

import com.domain.Cardrecord;
import com.domain.Carrecord;
import com.domain.Msg;
import com.domain.User1;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;
import com.service.CardrecordService;
import com.service.CarrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarrecordController {
    @Autowired
    CarrecordService service;
    @Autowired
    CardrecordService cardrecordService;



    Msg msg=new Msg();

    @RequestMapping(value = "/emps")
    @ResponseBody
    public Msg SelectAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 6);
        List<Carrecord> carrecordList = service.SelectAll();
        PageInfo pageInfo = new PageInfo(carrecordList);
        return Msg.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/emp")
    @ResponseBody
    public Msg SelectAlladmin(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<Carrecord> carrecordList = service.SelectAlls();
        PageInfo pageInfo = new PageInfo(carrecordList);
        return Msg.success().add("pageInfo", pageInfo);
    }


    @RequestMapping(value = "/selAlls")
    public String SelectAllPark(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 3);
        List<Carrecord> user1List = service.SelectAlls();
        PageInfo pageInfo = new PageInfo(user1List,3);
        model.addAttribute("page", pageInfo);
        return "adminIndex";
    }


    @RequestMapping(value = "/SelectAllCar")
    public String SelectAllCar(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 3);
        List<Carrecord> user1List = service.SelectAll();
        PageInfo pageInfo = new PageInfo(user1List,3);
        model.addAttribute("page", pageInfo);
        return "carRecord";
    }

    @RequestMapping("/CarList")
    public String findCarList(){
        return "CarList";
    }

    //办理年卡跳转页面
    @RequestMapping("/findnewvip")
    public String findnewvip(){
        return "newvip";
    }

    @RequestMapping(value = "/DeloneCar")
    public String Delone(int rid) {
        service.Delone(rid);
        return "redirect:emps";
    }

    @RequestMapping("/addEmpCar")
    @ResponseBody
    public Msg AddCar(Carrecord carrecord) {
        cardrecordService.selectByCarNumber(carrecord.getCarnumber());
        Boolean boolcar=service.CarNumber(carrecord.getCarnumber());
        if(boolcar){
            service.AddCar(carrecord);
            return msg.success();
        }else{
            return Msg.fail("车已停入,请勿重复停车");
        }
    }

    @RequestMapping("/selectCar")
    @ResponseBody
    public Msg selectCar(int rid) {
        Msg msg = new Msg();
        Carrecord carrecord = service.SelCarId(rid);
        return msg.success().add("Car", carrecord);
    }

    @RequestMapping("/UpdCar")
    @ResponseBody
    public Msg updcar(@RequestParam(value = "rid") int rid){
        service.UPD(rid);
        return msg.success();
    }


    @RequestMapping("/findvipcheck")
    public String findvipRe(){
        return "vipRecord";
    }


}
