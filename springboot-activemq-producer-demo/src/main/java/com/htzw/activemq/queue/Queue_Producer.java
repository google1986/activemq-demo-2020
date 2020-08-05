package com.htzw.activemq.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 10:19
 */
@Component
public class Queue_Producer {
    //JmsMessagingTemplate是Springboot的Jms模板，Spring的是JmsTemplate
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    //把ConfigBean类的ActiveMQQueue注入进来
    @Autowired
    private ActiveMQQueue activeMQQueue;

    /**
     * 发送Queue的方法
     */
    public void producerMsg() {
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "========" + UUID.randomUUID().toString());
    }

    /**
     * 间隔3秒投递，SpringBoot的Scheduled用来定时执行
     */
    @Scheduled(fixedDelay = 3000)
    public void producerMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "========Scheduled:"+UUID.randomUUID().toString());
        System.out.println("Scheduled 定时投递");
    }
}
