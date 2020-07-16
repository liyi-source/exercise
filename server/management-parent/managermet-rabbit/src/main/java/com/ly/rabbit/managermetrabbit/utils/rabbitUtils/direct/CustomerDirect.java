package com.ly.rabbit.managermetrabbit.utils.rabbitUtils.direct;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerDirect {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//绑定临时队列
                    exchange = @Exchange(value="directs",type = "direct"),//绑定的交换机和类型
                    key = {"info","error"}//指定路由key
            )
    })
    public void receive1(String message){
        System.out.println("消费1"+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//绑定临时队列
                    exchange = @Exchange(value="directs",type = "direct"),//绑定的交换机和类型
                    key = {"error"}//指定路由key
            )
    })
    public void receive2(String message){
        System.out.println("消费2"+message);
    }
}
