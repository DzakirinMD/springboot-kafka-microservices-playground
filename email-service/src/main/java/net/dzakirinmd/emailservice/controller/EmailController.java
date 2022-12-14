package net.dzakirinmd.emailservice.controller;

import net.dzakirinmd.emailservice.model.EmailDetails;
import net.dzakirinmd.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is for separately send email via REST
 */
@RestController
@RequestMapping("/api/v1/email-service")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-mail")
    public String sendEmail(@RequestBody EmailDetails emailDetails) {

        return emailService.sendSimpleMail(emailDetails);
    }
}
