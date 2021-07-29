package com.controller;

import com.domain.Carrecord;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {
    @Autowired
    private UserService userService;


    @RequestMapping("user")
    public String user1(){
        return "user";
    }

    @RequestMapping("stopCar")
    public void StopCar(Carrecord carrecord){
        userService.stopcar(carrecord);
    }
}
