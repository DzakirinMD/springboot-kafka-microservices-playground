package net.dzakirinmd.stockservice.kafka.consumer;

import net.dzakirinmd.basedomains.dto.OrderDTO;
import net.dzakirinmd.basedomains.dto.OrderEventDTO;
import net.dzakirinmd.stockservice.model.Orders;
import net.dzakirinmd.stockservice.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private OrdersRepository orderDTORepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEventDTO orderEventDto) {
        LOGGER.info(String.format("Order Event received in stock-service => %s" , orderEventDto.toString()));

        Orders orders = new Orders();
        orders.setOrderId(orderEventDto.getOrderDto().getOrderId());
        orders.setOrderName(orderEventDto.getOrderDto().getOrderName());
        orders.setOrderEmailRecipient(orderEventDto.getOrderDto().getOrderEmailRecipient());
        orders.setOrderQty(orderEventDto.getOrderDto().getOrderQty());
        orders.setOrderPrice(orderEventDto.getOrderDto().getOrderPrice());
        orders.setMessage(orderEventDto.getMessage());
        orders.setStatus(orderEventDto.getStatus());

        orderDTORepository.save(orders);
    }
}
