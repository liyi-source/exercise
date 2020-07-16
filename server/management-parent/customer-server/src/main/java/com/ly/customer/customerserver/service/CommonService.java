package com.ly.customer.customerserver.service;

import com.ly.customer.customerserver.entity.StaticData;
import com.ly.customer.customerserver.utils.AccessTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonService {

    public String getToken(String appId,String appSecript){
        String accessToken="";
//        AccessTokenUtils.getToken(StaticData,);
        return accessToken;
    }
}
