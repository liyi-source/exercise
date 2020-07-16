package com.ly.chat.managerchat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ly.chat.managerchat.mapper.UserMapper;
import com.ly.chat.managerchat.util.AccessTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    //登陆
    public Map<String,Object> login(String userId,String password){
        List<Map<String,Object>> list= userMapper.login(userId,password);
        Map<String,Object> rtnMap=new HashMap<String,Object>();
        if(list.size()<1){
            rtnMap.put("code","1001");
            rtnMap.put("msg","账号或密码错误！");
            return rtnMap;
        }else{
            String token="";
            try {
                token= AccessTokenUtils.getToken("Sfmklob5KIFVcCAF","X2bSFzErhdxEPj5lfIGtk4");
                rtnMap.put("code","200");
                rtnMap.put("msg","登陆成功");
                rtnMap.put("token",token);
                rtnMap.put("data",list.get(0));
            }catch(Exception e){
                e.printStackTrace();
            }
            return rtnMap;
        }
    }
    //根据user_id 查询好友信息
    public Map<String,Object> getAllRecordById(String userId){
        List<Map<String,Object>> list= userMapper.getAllRecordById(userId);
        Map<String,Object> rtnMap=new HashMap<String,Object>();
        rtnMap.put("code","200");
        rtnMap.put("msg","获取成功");
        rtnMap.put("data",list);
        return rtnMap;
    }
    //根据user_id 查询好友信息
    public Map<String,Object> saveChatRecord(Map<String,String> map){
        int flag= userMapper.saveChatRecord(map);
        Map<String,Object> rtnMap=new HashMap<String,Object>();
        if(flag>0){
            rtnMap.put("code","200");
            rtnMap.put("msg","插入成功");
        }else{
            rtnMap.put("code","2001");
            rtnMap.put("msg","插入失败");
        }
        return rtnMap;
    }
    //查询聊天记录
    public Map<String,Object> queryChatRecord(Map<String,String> map){
        List<JSONObject> list=new ArrayList<JSONObject>();
        Map<String,Object> rtnMap=new HashMap<String,Object>();
        try {
            //查询聊天记录
            list= userMapper.queryChatRecord(map);
            //更改消息状态
            int flag=userMapper.updateChatState(map);
            rtnMap.put("code","200");
            rtnMap.put("msg","查询成功");
            rtnMap.put("data", list);
        }catch(Exception e){
            e.printStackTrace();
            rtnMap.put("code","3001");
            rtnMap.put("msg","查询失败");
        }
        return rtnMap;
    }
    //获取该账号下所有好友
    public Map<String,Object> queryAllFriendById(String userId,String userName) {
        List<Map<String,Object>> list = userMapper.queryAllFriendById(userId,userName);
        Map<String,Object> rtnMap=new HashMap<String,Object>();
        rtnMap.put("code","200");
        rtnMap.put("msg","查询成功");
        rtnMap.put("data", list);
        return rtnMap;
    }
    //根据userid模糊查询用户
    public Map<String,Object> queryUser(String userId) {
        List<Map<String,Object>> list = userMapper.queryUser(userId);
        Map<String,Object> rtnMap=new HashMap<String,Object>();
        rtnMap.put("code","200");
        rtnMap.put("msg","查询成功");
        rtnMap.put("data", list);
        return rtnMap;
    }
    //添加好友
    public Map<String,Object> addFriend(String userId,String friendUserId) {
        int flag = userMapper.addFriend(userId,friendUserId);
        Map<String,Object> rtnMap=new HashMap<String,Object>();
        if(flag>0){
            rtnMap.put("code","200");
            rtnMap.put("msg","添加好友成功");
        }else{
            rtnMap.put("code","4001");
            rtnMap.put("msg","添加好友失败");
        }
        return rtnMap;
    }
}
