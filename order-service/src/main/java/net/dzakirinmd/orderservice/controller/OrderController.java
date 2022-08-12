package net.dzakirinmd.orderservice.controller;

import net.dzakirinmd.basedomains.dto.OrderDTO;
import net.dzakirinmd.basedomains.dto.OrderEventDTO;
import net.dzakirinmd.orderservice.kafka.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order-service")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody OrderDTO orderDto) {

        orderDto.setOrderId(UUID.randomUUID().toString());

        OrderEventDTO orderEventDto = new OrderEventDTO();
        orderEventDto.setStatus("PENDING");
        orderEventDto.setMessage("Order status is in pending state");
        orderEventDto.setOrderDto(orderDto);

        orderProducer.sendMessage(orderEventDto);

        return "Order placed successfully ...";
    }
}