package com.donny1i.concurrencyconsumerdemo.handler;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = {"test-topic"})
    public void handle(ConsumerRecord<?, ?> record) {
        logger.info("kafka record的key: " + record.key());
        logger.info("kafka record的value: " + record.value());
    }
}
