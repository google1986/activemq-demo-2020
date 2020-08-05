package com.htzw.activemq.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 15:10
 */
@Component
public class Topic_Producer {
    private final JmsMessagingTemplate jmsMessagingTemplate;
    private final ActiveMQTopic activeMQTopic;

    @Autowired
    public Topic_Producer(JmsMessagingTemplate jmsMessagingTemplate, ActiveMQTopic activeMQTopic){
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.activeMQTopic = activeMQTopic;
    }
    @Scheduled(fixedDelay = 3000L)
    public void produce(){
        jmsMessagingTemplate.convertAndSend(activeMQTopic,"主题消息是："+ UUID.randomUUID().toString());
    }
}
