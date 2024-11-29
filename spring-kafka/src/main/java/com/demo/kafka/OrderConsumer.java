package com.demo.kafka;
import com.demo.domain.Order;
import com.demo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class OrderConsumer {

    private final OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Order order) {
        log.info("Order received: {}", order);

        // Validar la orden
        order.setValidated(true);
        order.setValidationDate(LocalDate.now());

        // Guardar la orden en la base de datos
        orderRepository.save(order);

        log.info("Order validated and saved: {}", order);
    }
}