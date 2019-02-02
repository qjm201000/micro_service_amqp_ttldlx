package com.microservice.amqqp.amqp;

import com.microservice.amqqp.amqp.send.ImmediateSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * 简单测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpApplicationTests {

    @Autowired
    ImmediateSender immediateSender;
    @Test
    public void test() {
        immediateSender.send("我是一个延时消息",3000);//3秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

