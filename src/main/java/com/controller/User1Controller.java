package com.controller;

import com.domain.Msg;
import com.domain.User1;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class User1Controller {
    @Autowired
    User1Service user1Service;

    @RequestMapping(value = "/selectWith")
    public String SelectWith(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,10);
        List<User1> user1List=user1Service.WithD();
        PageInfo pageInfo=new PageInfo(user1List);
        model.addAttribute("page", pageInfo);
        return "ajaxlist";
    }

    //分页数据直接响应
    @RequestMapping("/emps1")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<User1> emps = user1Service.WithD();
        PageInfo page = new PageInfo(emps, 10);
        return Msg.success().add("pageInfo", page);

    }

    //修改时根据ID获取值
    @RequestMapping("/selectId")
    @ResponseBody
    public Msg selupdId(int  id) {
        Msg msg=new Msg();
        User1 user1 = user1Service.selupdId(id);
        return msg.success().add("emp",user1);
    }

    //查询所有
    @RequestMapping(value = "/selectAll")
    public String selectTbl2() {
        List<User1> user1s = user1Service.selectAll();
        for (User1 user1 : user1s) {
            System.out.println(user1);
        }
        return "index";
    }

    //修改方法
    @RequestMapping("/Upd")
    @ResponseBody
    public Msg Upd(User1 tblEmp){
        user1Service.UPD(tblEmp);
        return Msg.success();
    }
    //批量插入
    @RequestMapping(value = "/bathInsert")
    public String bathInset() {
        user1Service.bathInsert();
        return "index";

    }

    //单个插入
    @RequestMapping("/addEmp")
    public Msg add(User1 tblEmp){
        user1Service.add(tblEmp);
        return Msg.success();
    }

    //单个删除用户
    @RequestMapping(value = "/Delone")
    public Msg Delone(Integer userid){
        user1Service.delOne(userid);
        return Msg.success();
    }

    //批量删除
    @RequestMapping(value = "/bathDel/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmp(@PathVariable("ids") String ids){
        if(ids.contains("-")){
            List<Integer> del_ids=new ArrayList<>();
            String [] str_ids=ids.split("-");
            //组合id的集合
            for(String string:str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            user1Service.bathdelete(del_ids);
        }else{
            Integer id=Integer.parseInt(ids);
            user1Service.delOne(id);
        }
        return Msg.success();
    }


}
