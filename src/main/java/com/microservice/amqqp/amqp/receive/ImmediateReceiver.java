package com.microservice.amqqp.amqp.receive;

import com.microservice.amqqp.amqp.config.Config;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消费者消费消息
 */
@Component
@EnableRabbit
@Configuration
public class ImmediateReceiver {
    @RabbitListener(queues = Config.IMMEDIATE_QUEUE)
    @RabbitHandler
    public void get(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("收到延时消息时间："+sdf.format(new Date()) + " Delay sent.");
        System.out.println("收到延时消息了:" + msg);
    }
}
