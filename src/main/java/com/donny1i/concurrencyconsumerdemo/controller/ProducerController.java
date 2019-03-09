package com.donny1i.concurrencyconsumerdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafkaProducer")
public class ProducerController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendKafka(String message) {
        try {
            kafkaTemplate.send("test-topic", message, message);
            return "success";
        } catch(Exception e) {
            return "fail";
        }
    }
}
