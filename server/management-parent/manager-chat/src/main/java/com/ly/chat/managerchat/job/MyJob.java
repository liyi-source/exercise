package com.ly.chat.managerchat.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class MyJob {

//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//    @Scheduled(fixedRate = 1000)
//    public void sendMesage(){
//        System.out.println("1");
//        simpMessagingTemplate.convertAndSend("/server/sendMessageByServer",System.currentTimeMillis());
//    }

//    @Scheduled(fixedRate = 5000)
//    public void sendMesageToUser(){
//        simpMessagingTemplate.convertAndSendToUser("1","/sendMessage","==="+System.currentTimeMillis());
//    }
}
