package com.ly.chat.managerchat.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<Map<String,Object>> login(String userId, String password);

    List<Map<String,Object>> getAllRecordById(String userId);

    //保存聊天记录
    int saveChatRecord(Map<String,String> map);
    //查询聊天记录
    List<JSONObject> queryChatRecord(Map<String,String> map);
    //更改消息状态
    int updateChatState(Map<String,String> map);
    //获取该账号下所有好友
    List<Map<String,Object>> queryAllFriendById(String userId , String userName);
    //根据userid模糊查询用户
    List<Map<String,Object>> queryUser(String userId);
    //添加好友
    int addFriend(String userId , String friendUserId);

}
