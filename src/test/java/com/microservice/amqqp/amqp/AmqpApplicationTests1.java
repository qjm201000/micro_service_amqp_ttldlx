package com.microservice.amqqp.amqp;

import com.microservice.amqqp.amqp.send.ImmediateSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpApplicationTests1 {

    @Autowired
    ImmediateSender immediateSender;

    /**
     * 发送三条消息，设置延时时间，发现所有的都在等待；
     * 这是因为符合先进先出原则，三条消息是依次被消费，并不会因为时间到了，就消费
     */
    @Test
    public void test() {
        immediateSender.send("我是一个延时消息，睡10秒",10000);//10秒
        immediateSender.send("我是一个延时消息，睡2秒",2000);//2秒
        immediateSender.send("我是一个延时消息，睡1秒",1000);//1秒

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

