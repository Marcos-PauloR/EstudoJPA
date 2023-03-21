package com.cursojpa.cursojpa.service;

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
    
}
