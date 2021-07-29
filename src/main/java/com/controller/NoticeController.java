package com.controller;

import com.domain.Msg;
import com.domain.Notice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    //查询公告信息
    @RequestMapping("/noticesel")
    @ResponseBody
    public String noticesel(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 15);
        List<Notice> notices = noticeService.NoticeSel();
        PageInfo pageInfo = new PageInfo(notices);
        model.addAttribute("noticeList", pageInfo);
//        return Msg.success().add("pageInfo", pageInfo);
        return "CarList";
    }


    //直接响应数据
    @RequestMapping(value = "/notsel")
    @ResponseBody
    public Msg SelectAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 15);
        List<Notice> notices = noticeService.NoticeSel();
        PageInfo pageInfo = new PageInfo(notices);
        return Msg.success().add("noticeList", pageInfo);
    }

    //单个删除
    @RequestMapping("/DelNo")
    @ResponseBody
    public Msg DelNotice(int noid){
        noticeService.DelNo(noid);
        return Msg.success();
    }

    @RequestMapping("/noticeAdd")
    @ResponseBody
    public Msg AddNotice(String notice){
        if(notice==null||notice.equals("")){
            return Msg.fail("公告信息不能为空");
        }else {
            noticeService.AddNotice(notice);
            return Msg.success("公告信息添加成功");
        }
    }

    //查询审核中年卡信息
    @RequestMapping(value="/findinsertNo")
    public ModelAndView findinsertNo() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("insertNo");
        return modelAndView;
    }

}
