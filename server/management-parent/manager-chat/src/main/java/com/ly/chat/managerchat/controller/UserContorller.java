package com.ly.chat.managerchat.controller;

import com.ly.chat.managerchat.service.UserService;
import com.ly.chat.managerchat.util.AccessTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserContorller {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "success";
    }

    //登陆
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        Map<String,Object> rtnMap=userService.login(userId,password);
        return rtnMap;
    }

    //查询所有聊天记录
    @RequestMapping("/getAllRecordById")
    @ResponseBody
    public Map<String,Object> getAllRecordById(HttpServletRequest request){
        String userId=request.getParameter("userId");
        return userService.getAllRecordById(userId);
    }

    //查询该账号下所有好友
    @RequestMapping("/getAllFriendById")
    @ResponseBody
    public Map<String,Object> getAllFriendById(HttpServletRequest request){
        String userId=request.getParameter("userId");
        String userName=request.getParameter("userName");
        return userService.queryAllFriendById(userId,userName);
    }
    //根据userid模糊查询用户
    @RequestMapping("/queryUser")
    @ResponseBody
    public Map<String,Object> queryUser(HttpServletRequest request){
        String userId=request.getParameter("userId");
        return userService.queryUser(userId);
    }

    //添加用户
    @RequestMapping("/addFriend")
    @ResponseBody
    public Map<String,Object> addFriend(HttpServletRequest request){
        String userId=request.getParameter("userId");
        String friendUserId=request.getParameter("friendUserId");
        return userService.addFriend(userId,friendUserId);
    }

}
