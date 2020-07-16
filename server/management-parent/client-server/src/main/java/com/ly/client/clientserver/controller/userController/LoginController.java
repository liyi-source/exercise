package com.ly.client.clientserver.controller.userController;

import com.ly.client.clientserver.entity.RtnData;
import com.ly.client.clientserver.service.userService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "端口： "+this.port;
    }

    @GetMapping(value ="/user/login",produces = "application/json;charset=utf-8")
    public RtnData login(){
        RtnData rtnData =loginService.login();
        return rtnData;
    }
}
