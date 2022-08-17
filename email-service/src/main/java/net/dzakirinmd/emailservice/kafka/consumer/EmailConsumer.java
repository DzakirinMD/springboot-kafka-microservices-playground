package net.dzakirinmd.emailservice.kafka.consumer;

import net.dzakirinmd.basedomains.dto.OrderEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEventDTO orderEventDto) {
        LOGGER.info(String.format("Order Event received in email-service => %s" , orderEventDto.toString()));

        // TODO send email to customer

    }

}
