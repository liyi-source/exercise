package com.ly.upload.managentupload.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    @Autowired
//    private Sender sender;

    @GetMapping(value = "/login",produces = "application/json;charset=utf-8")
    public Map<String,String> login(){
        Map<String,String> map=new HashMap<>();

        map.put("rtnCode","1");
        map.put("rtnMsg","登陆成功");
        return map;
    }

    @PostMapping(value = "/sendMessage", produces = "application/json;charset=utf-8")
    public void sendMessage(@RequestBody String param){
        JSONObject jsonObject = JSONObject.parseObject(param);
        String msg=(String) jsonObject.get("msg");
//        sender.send(param);
    }
}
