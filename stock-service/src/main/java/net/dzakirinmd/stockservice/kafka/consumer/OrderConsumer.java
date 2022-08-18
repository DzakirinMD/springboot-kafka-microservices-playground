package net.dzakirinmd.stockservice.kafka.consumer;

import net.dzakirinmd.basedomains.dto.OrderDTO;
import net.dzakirinmd.basedomains.dto.OrderEventDTO;
import net.dzakirinmd.basedomains.repository.OrderDTORepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private OrderDTORepository orderDTORepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEventDTO orderEventDto) {
        LOGGER.info(String.format("Order Event received in stock-service => %s" , orderEventDto.toString()));

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderEventDto.getOrderDto().getOrderId());
        orderDTO.setOrderName(orderEventDto.getOrderDto().getOrderName());
        orderDTO.setOrderEmailRecipient(orderEventDto.getOrderDto().getOrderEmailRecipient());
        orderDTO.setOrderQty(orderEventDto.getOrderDto().getOrderQty());
        orderDTO.setOrderPrice(orderEventDto.getOrderDto().getOrderPrice());

        orderDTORepository.save(orderDTO);
    }
}
