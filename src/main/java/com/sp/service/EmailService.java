package com.sp.service;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements EmailServiceIn {

    private final JavaMailSender emailSender;
    private final MailProperties mailProperties;

   
    public EmailService(JavaMailSender emailSender, MailProperties mailProperties) {
        this.emailSender = emailSender;
        this.mailProperties = mailProperties;
    }

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailProperties.getUsername());
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        } catch (MailException ex) {
            // Log the exception or handle it appropriately
            ex.printStackTrace();
            
        }
    }
}
