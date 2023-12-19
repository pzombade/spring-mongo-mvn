package com.spring.mongo.springmongo.service.mq;

import com.spring.mongo.springmongo.models.User;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqSender {
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.routingkey}")
    private String queueName;

    private RabbitTemplate template;

    private Queue queue;

    public RabbitMqSender(RabbitTemplate template, Queue q){
        this.rabbitTemplate = template;
        this.queue = q;
    }

    public void send(User user){
        this.rabbitTemplate.convertAndSend(this.queue.getName(), "Hello");
    }

    public void send(String msg){
        this.rabbitTemplate.convertAndSend(queueName, msg);
    }
}
