package com.fluex404.springbootrabbitmq.amqp;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private MessageConverter jsonMessageConverter;

    @Value("${myExchange}")
    private String exchange;

    @Value("${myRoutingKey}")
    private String routingKey;


    public void produceMsg(String msg) {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("Send msg = " + msg);
    }

    public void produceMsg(Object msg) {
        ((RabbitTemplate) amqpTemplate).setMessageConverter(jsonMessageConverter);
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("Send msg = " + msg);
    }

}