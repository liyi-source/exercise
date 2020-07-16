package com.ly.chat.managerchat.controller;

import com.alibaba.fastjson.JSONObject;
import com.ly.chat.managerchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SendMessage {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserService userService;

//    发送消息
    @RequestMapping(value = "/sendMessage")
    @ResponseBody
    public String sendMessage(HttpServletRequest request){
        String msg=request.getParameter("msg");
        String toUserId=request.getParameter("toUserId");
        String fromUserId=request.getParameter("fromUserId");
        Map<String,String> map=new HashMap<String,String>();
        map.put("toUserId",toUserId);
        map.put("fromUserId",fromUserId);
        map.put("msg",msg);
        String jsonStr=JSONObject.toJSONString(map);
        simpMessagingTemplate.convertAndSendToUser(fromUserId+"="+toUserId,"/sendMessage",jsonStr);
        //插入数据库保存聊天记录
        //拼接参数
        map.put("msgType","text");
        String trnStr=JSONObject.toJSONString(userService.saveChatRecord(map));
        return trnStr;
    }
    //查询聊天记录
    @RequestMapping(value = "/queryChatRecord")
    @ResponseBody
    public Map<String,Object> queryChatRecord(HttpServletRequest request){
        String toUserId=request.getParameter("toUserId");
        String fromUserId=request.getParameter("fromUserId");
        Map<String,String> map=new HashMap<String,String>();
        map.put("toUserId",toUserId);
        map.put("fromUserId",fromUserId);
        Map<String,Object> rtnMap=userService.queryChatRecord(map);
        return rtnMap;
    }
}
