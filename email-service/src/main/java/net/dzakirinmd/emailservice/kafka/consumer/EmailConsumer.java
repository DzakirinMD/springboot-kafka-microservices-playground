package net.dzakirinmd.emailservice.kafka.consumer;

import net.dzakirinmd.basedomains.dto.OrderDTO;
import net.dzakirinmd.basedomains.dto.OrderEventDTO;
import net.dzakirinmd.emailservice.model.EmailDetails;
import net.dzakirinmd.emailservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * This class is for email automation
 */
@Service
public class EmailConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailConsumer.class);

    @Autowired
    private EmailService emailService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrder(OrderEventDTO orderEventDto) {
        LOGGER.info(String.format("Order Event received in email-service => %s" , orderEventDto.toString()));

        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(orderEventDto.getOrderDto().getOrderEmailRecipient());
        emailDetails.setSubject("Automated order receipt for: " + orderEventDto.getOrderDto().getOrderName());
        emailDetails.setMsgBody("Hi!\n\n" +
                "Your order has been created. Below are the details : " +
                "\nTotal quantity: " + orderEventDto.getOrderDto().getOrderQty() +
                "\nTotal price: " + orderEventDto.getOrderDto().getOrderPrice() +
                "\n\nThank You !!"
        );

        String status = emailService.sendSimpleMail(emailDetails);

        LOGGER.info(String.format("Automated order email has been send in email-service => %s" , status));
    }

}
