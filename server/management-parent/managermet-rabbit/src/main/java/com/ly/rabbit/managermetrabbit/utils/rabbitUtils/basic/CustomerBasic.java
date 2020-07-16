package com.ly.rabbit.managermetrabbit.utils.rabbitUtils.basic;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value="hello",declare = "true"))
public class CustomerBasic {

    @RabbitHandler
    public void receive(String message){
        System.out.println("消费"+message);
    }
}
