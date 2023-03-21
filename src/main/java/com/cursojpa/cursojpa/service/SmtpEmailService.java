package com.cursojpa.cursojpa.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService{

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;
    
    private static final Logger Log = LoggerFactory.getLogger(SmtpEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        Log.info("Simulando Envio de email...");
        mailSender.send(msg);
        Log.info("Email Enviado!");   
    }

    @Override
    public void sendHtmlEmail(MimeMessage mailMessage) {
        Log.info("Simulando Envio de email...");
        javaMailSender.send(mailMessage);
        Log.info("Email Enviado!");   
    }
    
}
