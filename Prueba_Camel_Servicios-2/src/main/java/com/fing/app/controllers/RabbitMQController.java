package com.fing.app.controllers;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fing.app.rabbitmq.RabbitMQProducer;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer producer;
    
    @Produce("direct:sendToRabbit")
    private ProducerTemplate producerTemplate;

    
    @Produce("direct:setRedis")
    private ProducerTemplate producerRedisTemplate;
    
    
    @GetMapping("/hola")
    public String hola() {
        
        return "Hola";
    }
    
    
    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent to RabbitMQ: " + message;
    }
    
    @GetMapping("/send2")
    public String send2Message(@RequestParam String message) {
        
        producerTemplate.sendBody("direct:sendToRabbit", message);
        
        producerRedisTemplate.sendBody("direct:setRedis", message);
        
        return "Message sent to RabbitMQ";
    }
}
