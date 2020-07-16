package com.ly.customer.customerserver.controller;

import com.ly.customer.customerserver.service.CustomerService;
import com.ly.customer.customerserver.utils.AccessTokenUtils;
import com.ly.customer.customerserver.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CustonerController {

    @Autowired
    private CustomerService customerService;


    @ResponseBody
    @GetMapping("/test")
    public String test(){
        System.out.println("进来");
        return "成功";
    }

    @ResponseBody
    @GetMapping(value = "/login",produces = "application/json;charset=UTF-8")
    public String login(){
        String token="";
        try {
            String appId=AppUtils.getAppId();
            String appSecript=AppUtils.uuid(14);
            token=AccessTokenUtils.getToken(appId,appSecript);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
