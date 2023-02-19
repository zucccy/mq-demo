package cn.itcast.mq.listenr;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @Description: TODO
 * @Author: ChenYun
 * @CreateDate: 2023/2/16 14:22
 * @Version 1.0
 */
@Component
// 添加Component注解，将这个类注册成Bean放入Spring容器
public class SpringRabbitListenr {

    //添加该注解，表明使用ListenSimpleQueue方法来消费消息
//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueue(String msg) {
//        System.out.println("消费者接受到simple.queue的消息：【" + msg + "】");
//    }

    // workqueue1，工作能力强，每秒处理50条消息
    @RabbitListener(queues = "simple.queue")
    public void ListenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1接受到消息：【" + msg + "】" + LocalTime.now());
        Thread.sleep(20);
    }

    // workqueue2，工作能力弱，每秒处理5条消息
    @RabbitListener(queues = "simple.queue")
    public void ListenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2接受到消息........：【" + msg + "】" + LocalTime.now());
        Thread.sleep(200);
    }
}
