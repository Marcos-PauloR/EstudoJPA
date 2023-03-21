package com.cursojpa.cursojpa.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.cursojpa.cursojpa.domain.Pedido;

public interface EmailService {
    

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage mailMessage);

    void sendOrderConfirmationEmailHtmlEmail(Pedido pedido);

    void sendHtmlEmail(MimeMessage mailMessage);
}
