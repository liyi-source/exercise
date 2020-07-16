package com.ly.user.managermentuser.controller;

import com.ly.user.managermentuser.entity.RtnData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("server.port")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "端口： "+this.port;
    }

    @GetMapping(value = "/login",produces = "application/json;charset=utf-8")
    public RtnData login(){
        RtnData rtnData=new RtnData();
        rtnData.setRtnCode(1);
        rtnData.setRtnMsg("登陆成功");
        return rtnData;
    }

}
