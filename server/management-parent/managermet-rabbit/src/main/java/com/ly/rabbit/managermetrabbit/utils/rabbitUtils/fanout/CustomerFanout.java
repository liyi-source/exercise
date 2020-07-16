package com.ly.rabbit.managermetrabbit.utils.rabbitUtils.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerFanout {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//绑定临时队列
                    exchange = @Exchange(value="logs",type = "fanout")//绑定的交换机和类型
            )
    })
    public void receive1(String message){
        System.out.println("消费1"+message);
    }
}
