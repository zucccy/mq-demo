package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: TODO
 * @Author: ChenYun
 * @CreateDate: 2023/2/16 11:01
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
// Spring单元测试需要加上上面两个注解
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Test
//    public void testSendMessage2SimpleQueue() {
//        String queueName = "simple.queue";
//        String message = "Hello SpringAMQP!";
//        rabbitTemplate.convertAndSend(queueName, message);
//    }

    @Test
    public void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "Hello message__";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName, message + i);
            Thread.sleep(20);
        }
    }
}
