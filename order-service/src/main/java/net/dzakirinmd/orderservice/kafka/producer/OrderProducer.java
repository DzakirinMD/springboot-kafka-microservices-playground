package net.dzakirinmd.orderservice.kafka.producer;

import net.dzakirinmd.basedomains.dto.OrderEventDto;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Autowired
    private NewTopic newTopic;

    // need to add base-domains in pom.xml dependency
    @Autowired
    private KafkaTemplate<String, OrderEventDto> kafkaTemplate;

    public void sendMessage(OrderEventDto orderEventDto) {

        LOGGER.info(String.format("Order event sent => %s" , orderEventDto.toString()));

        // create message
        Message<OrderEventDto> message = MessageBuilder
                .withPayload(orderEventDto)
                .setHeader(KafkaHeaders.TOPIC, newTopic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
