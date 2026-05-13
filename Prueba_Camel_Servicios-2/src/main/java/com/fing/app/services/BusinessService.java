package com.fing.app.services;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    @Autowired
    private ProducerTemplate producerTemplate;

    public void processData() {
        // Set value
        producerTemplate.sendBody("direct:setRedis", "Hello Camel 4.19");
        // Get value
        String cachedValue = producerTemplate.requestBody("direct:getRedis", null, String.class);
    }
}
