package com.htzw.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/4 14:59
 */
public class JMSProducer {
    public static final String ACTIVEMQ_URL = "tcp://192.168.67.130:61616";
    public static final String QUEUE_NAME = "queue_001";

    public static void main(String[] args) throws JMSException {
        // 1.创建连接工厂，按照给定的url地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂，获得连接connection，并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        /**
         * 3.创建会话session
         * 两个参数，第一个叫事务，第二个叫签收
         */
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地（具体是队列还是主题topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer messageProducer = session.createProducer(queue);
        //5.通过使用messageProducer产生3条消息发送到MQ的队列中
        for (int i = 1; i <= 3; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("msg-----" + i);
            messageProducer.send(textMessage);
        }
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("-----消息发布到MQ完成");
    }
}
