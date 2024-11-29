package com.demo.controller;

import com.demo.domain.Order;
import com.demo.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    @PostMapping("/send")
    ResponseEntity<?> createOrder(@RequestBody Order order){
        orderProducer.sendOrder(order);
        return ResponseEntity.ok("Order successfully sent");
    }
}
