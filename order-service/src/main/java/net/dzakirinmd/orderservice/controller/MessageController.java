package net.dzakirinmd.orderservice.controller;

import net.dzakirinmd.basedomains.dto.OrderDto;
import net.dzakirinmd.basedomains.dto.OrderEventDto;
import net.dzakirinmd.orderservice.kafka.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(name = "/api/v1/order-service")
public class MessageController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/orders")
    public String placeOrder(OrderDto orderDto) {

        orderDto.setOrderId(UUID.randomUUID().toString());

        OrderEventDto orderEventDto = new OrderEventDto();
        orderEventDto.setStatus("PENDING");
        orderEventDto.setMessage("Order status is in pending state");
        orderEventDto.setOrderDto(orderDto);

        orderProducer.sendMessage(orderEventDto);

        return "Order placed sucessfully ...";
    }
}
