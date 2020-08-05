package com.htzw.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 10:15
 */
@Component
@EnableJms //开启SpringBoot的Jms
public class ConfigBean {
    @Value("${myQueueName}")
    private String myQueueName;

    @Bean
    public ActiveMQQueue queue(){
        // 创建一个ActiveMQQueue
        return new ActiveMQQueue(myQueueName);
    }
}
