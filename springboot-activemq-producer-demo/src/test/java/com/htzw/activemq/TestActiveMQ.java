package com.htzw.activemq;

import com.htzw.activemq.queue.Queue_Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/5 14:14
 */
@SpringBootTest(classes = MainApp_Producer.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestActiveMQ {
    @Autowired
    private Queue_Producer queue_producer;

    @Test
    public void testSend(){
        queue_producer.producerMsg();
    }
}
