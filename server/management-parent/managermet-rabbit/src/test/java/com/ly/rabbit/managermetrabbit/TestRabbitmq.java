package com.ly.rabbit.managermetrabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=ManagermetRabbitApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitmq {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testBasic(){
        System.out.println("进来");
        rabbitTemplate.convertAndSend("hello","hello-word");

    }
    @Test
    public void testWork(){
        for (int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("work","work");
        }
    }
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","fanout");
    }

    @Test
        public void testDirect(){
        rabbitTemplate.convertAndSend("directs","error","derect");
    }

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","topic");
    }
}
