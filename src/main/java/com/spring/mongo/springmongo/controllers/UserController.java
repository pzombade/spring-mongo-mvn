package com.spring.mongo.springmongo.controllers;

import com.spring.mongo.springmongo.models.User;
import com.spring.mongo.springmongo.service.mq.RabbitMqSender;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mq")
public class UserController {

    private final RabbitMqSender rabbitMqSender;

    public UserController(RabbitMqSender sender){
        this.rabbitMqSender = sender;
    }

    @GetMapping("/user/{msg}")
    public ApiResponse createUser(@PathVariable  String msg){
        System.out.println("Hello " + msg);
        this.rabbitMqSender.send("Hello " + msg);
        return new ApiResponse();
    }
}
