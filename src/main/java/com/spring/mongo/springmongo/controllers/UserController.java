package com.spring.mongo.springmongo.controllers;

import com.spring.mongo.springmongo.models.User;
import com.spring.mongo.springmongo.service.mq.RabbitMqSender;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class UserController {

    private final RabbitMqSender rabbitMqSender;

    public UserController(RabbitMqSender sender){
        this.rabbitMqSender = sender;
    }

    @PostMapping("/user")
    public ApiResponse createUser(@RequestBody User user){
        this.rabbitMqSender.send(user);
        return new ApiResponse();
    }
}
