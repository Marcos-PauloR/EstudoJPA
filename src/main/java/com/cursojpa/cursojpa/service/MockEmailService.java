package com.cursojpa.cursojpa.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService{

    private static final Logger Log = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage mailMessage) {
        Log.info("Simulando Envio de email...");
        Log.info(mailMessage.toString());    
        Log.info("Email Enviado!");    
    }

    @Override
    public void sendHtmlEmail(MimeMessage mailMessage) {
        Log.info("Simulando Envio de email HTML...");
        Log.info(mailMessage.toString());    
        Log.info("Email Enviado!");
    }

    
    
}
