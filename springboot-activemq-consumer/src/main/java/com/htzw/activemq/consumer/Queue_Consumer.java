package com.htzw.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 13:48
 */
@Component
public class Queue_Consumer {
    @JmsListener(destination = "${myQueueName}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("==============消费者收到消息："+textMessage.getText());
    }
}
