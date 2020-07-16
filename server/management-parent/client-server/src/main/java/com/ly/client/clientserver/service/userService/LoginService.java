package com.ly.client.clientserver.service.userService;

import com.ly.client.clientserver.entity.RtnData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name="user")
public interface LoginService {
    @GetMapping(value ="/user/login",produces = "application/json;charset=utf-8")
    public RtnData login();
}
