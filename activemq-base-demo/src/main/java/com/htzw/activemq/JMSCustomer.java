package com.htzw.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/8/4 14:59
 */
public class JMSCustomer {
    public static final String ACTIVEMQ_URL = "tcp://192.168.67.130:61616";
    public static final String QUEUE_NAME = "queue_001";

    public static void main(String[] args) throws JMSException, IOException {
        // 1.创建连接工厂，按照给定的url地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂，获得连接connection,并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        /**
         * 3.创建会话session
         * 两个参数，第一个叫事务，第二个叫签收
         */
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地（具体是队列还是主题topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageConsumer messageConsumer = session.createConsumer(queue);
        //5.创建消费者
        /*
        同步阻塞方式（receive()）
        订阅者或者接收者调用MessageConsumer的receive()方法来接收消息，receive方法在能够接收到消息之前（或者超时之前）将一直阻塞
        while (true) {
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            if (textMessage != null) {
                System.out.println("========消费者收到消息："+textMessage.getText());
            }else {
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();
        */

        /**
         * 通过监听的方式来获取消息MessageConsumer messageConsumer = session.createConsumer(queue);
         * 异步非阻塞方式（监听器onMessage()）
         * 订阅者或者接受者通过MessageConsumer的setMessageListener(MessageListener listener)注册一个消息监听器
         * 当消息到达之后，系统自动调用监听器MessageListener的onMessage(Message message)方法
         */
        messageConsumer.setMessageListener(message -> {
            if (message != null) {
                try {
                    System.out.println("=====消费者收到信息：" + ((TextMessage) message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
    }
}
