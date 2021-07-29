package com.controller;

import com.domain.Cardrecord;
import com.domain.Carrecord;
import com.domain.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.CardrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CardrecordController {
    @Autowired
    CardrecordService cardrecordService;



    Msg msg=new Msg();

    @RequestMapping("/addNewCard")
    @ResponseBody
    public Msg addNewcard(Cardrecord cardrecord){
        Boolean boll=cardrecordService.CarNumber(cardrecord);
        if(boll==true){
            cardrecordService.AddNew(cardrecord);
        }else{
            cardrecordService.UpdNew(cardrecord);
        }
        return Msg.success("办理会员卡成功，请等待审核通过");

    }

    //查询审核中年卡信息
    @RequestMapping(value="/Cardresel")
    public ModelAndView newoutcar() {
        ModelAndView modelAndView=new ModelAndView();
        List<Cardrecord> cardrecords = cardrecordService.CardreSel();
        modelAndView.addObject("page", cardrecords);
        modelAndView.setViewName("vipCheck");
        return modelAndView;
    }

    @RequestMapping(value = "/updCardre")
    public String updCardre(Cardrecord cardrecord) {
        cardrecordService.updCardre(cardrecord);
        return "redirect:Cardresel";
    }

    //查询审核通过年卡信息
    @RequestMapping(value="/Cardresels")
    public ModelAndView newoutcars() {
        ModelAndView modelAndView=new ModelAndView();
        List<Cardrecord> cardrecords = cardrecordService.CardreSels();
        modelAndView.addObject("page", cardrecords);
        modelAndView.setViewName("vipRecord");
        return modelAndView;
    }

    //删除审核中状态信息
    @RequestMapping(value = "/DelCared")
    public String DelCarre(Integer cid){
        cardrecordService.DelCardre(cid);
        return "redirect:Cardresel";
    }

    @RequestMapping("/selectMsg")
    @ResponseBody
    public  Msg selectMsg(){
        int carNum=cardrecordService.selectNum();
        int money=(carNum*1000)+(cardrecordService.selectMoney());
        int ke=cardrecordService.selectCheWei(1);
        int yi=cardrecordService.selectCheWei(2);
        return Msg.success().add("carNum",carNum).add("money",money).add("ke",ke).add("yi",yi);
    }

}
