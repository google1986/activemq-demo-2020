package com.htzw.activemq.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 15:08
 */
@Component
@EnableJms
public class ActiveMQTopicConfigBean {
    @Value("${myTopicName}")
    private String myTopicName;

    @Bean
    public ActiveMQTopic activeMQTopic(){
        return new ActiveMQTopic(myTopicName);
    }
}
