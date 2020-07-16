package com.ly.customer.customerserver.utils;

//import com.alibaba.fastjson.JSONObject;
//import com.tl.handlpower.entity.Constant;
//import com.tl.handlpower.exception.MyException;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * AccessTokenUtil
 * token 处理类
 * @author majianxiang
 * @date 2020/4/15
 */
public class AccessTokenUtils {



    /**
    * 
    * 返回一个 token
    * 将用户的 获取时间 和 获取时间进行  加密 而后拼接随机的一个5位字符 组成无规律的 长字符串
    * 此字符无法用来 直接解密
    * @Author: majianxiang
    * @DateTime: 2020/4/15 14:59
    * @Params: []
    * @Return java.lang.String
    */
    public static String getToken(String appId, String appSecript) throws Exception {


        HashMap<String, String> hm = new HashMap<>();
        hm.put("appId",appId);
        hm.put("appSecript",appSecript);
        String createTime = String.valueOf(System.currentTimeMillis());

        hm.put("createTime", createTime);
        String js = JSONObject.toJSONString(hm);
        // 生成 加密的 字符串
        String encrypt = AESUtils.aesEncrypt(js, AESUtils.KEY);
        String replace = UUID.randomUUID().toString().replace("-", "");
        String joinStr = replace.substring(0, 5);

        // 最终 返回的信息  是一个 拼接信息 无法直接解密 也无规律
        return joinStr+encrypt;
    }


    public static void main(String[] args) throws Exception {
        String token = getToken("gfasdfas", "fasdfasd");

        System.out.println("token = " + token);

        // 解密的话 需要 进行 截取
        String realToken = token.substring(5, token.length());

        String s = AESUtils.aesDecrypt(realToken, AESUtils.KEY);

        System.out.println("s = " + s);
    }



    /**
    *
    * token 的校验
    * @Author: majianxiang
    * @DateTime: 2020/4/16 16:53
    * @Params: [appId, appSecript]
    * @Return java.lang.String
    */
    public static boolean checkToken(String access_token) {
        String realToken = access_token.substring(5);
        String json = "";
        try {
            json = AESUtils.aesDecrypt(realToken, AESUtils.KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String,String> map = JSONObject.parseObject(json, Map.class);

        String createTime = map.get("createTime");
        long nowTime = System.currentTimeMillis();
        if (nowTime > Long.parseLong(createTime) && (nowTime - Long.parseLong(createTime)) < 1000 * 60 * 60 * 2 ) {
            return true;
        } else {
            return false;
        }
    }
}