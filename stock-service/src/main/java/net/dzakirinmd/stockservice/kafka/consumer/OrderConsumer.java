package net.dzakirinmd.stockservice.kafka.consumer;

import net.dzakirinmd.basedomains.dto.OrderEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEventDTO orderEventDto) {
        LOGGER.info(String.format("Order Event received in stock-service => %s" , orderEventDto.toString()));

        // TODO save the order event into the database

    }

}
