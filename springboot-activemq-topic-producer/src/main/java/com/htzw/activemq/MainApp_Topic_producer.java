package com.htzw.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 15:13
 */
@SpringBootApplication
@EnableScheduling
public class MainApp_Topic_producer {
    public static void main(String[] args) {
        SpringApplication.run(MainApp_Topic_producer.class, args);
    }
}
