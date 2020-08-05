package com.htzw.activemq.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 15:23
 */
@Component
public class Topic_Consumer {
    @JmsListener(destination = "${myTopicName}")
    public void consumer(TextMessage textMessage) throws JMSException {
        System.out.println("订阅者收到信息："+textMessage.getText());
    }
}
