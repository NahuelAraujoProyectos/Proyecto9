package com.demo.kafka;

import com.demo.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        log.info("Sending order...");
        kafkaTemplate.send(defaultTopic, order);
    }
}
