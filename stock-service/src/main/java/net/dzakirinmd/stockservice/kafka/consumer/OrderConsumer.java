package net.dzakirinmd.stockservice.kafka.consumer;

import net.dzakirinmd.basedomains.dto.OrderEventDTO;
import net.dzakirinmd.stockservice.model.StoredOrder;
import net.dzakirinmd.stockservice.repository.StoredOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private StoredOrderRepository storedOrderRepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEventDTO orderEventDto) {
        LOGGER.info(String.format("Order Event received in stock-service => %s" , orderEventDto.toString()));

        // TODO save the order event into the database
        StoredOrder storedOrder = new StoredOrder();
        storedOrder.setOrderId(orderEventDto.getOrderDto().getOrderId());
        storedOrder.setOrderName(orderEventDto.getOrderDto().getOrderName());
        storedOrder.setOrderQty(orderEventDto.getOrderDto().getOrderQty());
        storedOrder.setOrderPrice(orderEventDto.getOrderDto().getOrderPrice());
        storedOrder.setMessage(orderEventDto.getMessage());
        storedOrder.setStatus(orderEventDto.getStatus());

        storedOrderRepository.save(storedOrder);

    }

}
