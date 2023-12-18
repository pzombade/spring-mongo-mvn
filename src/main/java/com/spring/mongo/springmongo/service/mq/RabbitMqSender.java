package com.spring.mongo.springmongo.service.mq;

import com.spring.mongo.springmongo.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public RabbitMqSender(RabbitTemplate template){
        this.rabbitTemplate = template;
    }

    public void send(User user){
        this.rabbitTemplate.convertAndSend(exchange, routingkey, user);
    }
}
