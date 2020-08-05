package com.htzw.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 10:23
 */
@SpringBootApplication
@EnableScheduling
public class MainApp_Producer {
    public static void main(String[] args) {
        SpringApplication.run(MainApp_Producer.class, args);
    }
}
