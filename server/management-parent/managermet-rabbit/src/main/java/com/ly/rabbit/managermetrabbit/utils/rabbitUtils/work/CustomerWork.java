package com.ly.rabbit.managermetrabbit.utils.rabbitUtils.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerWork {
    @RabbitListener(queuesToDeclare = @Queue(value="work"))
    public void receive1(String message){
        System.out.println("消费1"+message);
    }
    @RabbitListener(queuesToDeclare = @Queue(value="work"))
    public void receive2(String message){
        System.out.println("消费2"+message);
    }
}
