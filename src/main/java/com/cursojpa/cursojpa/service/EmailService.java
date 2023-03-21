package com.cursojpa.cursojpa.service;

import org.springframework.mail.SimpleMailMessage;

import com.cursojpa.cursojpa.domain.Pedido;

public interface EmailService {
    

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage mailMessage);

}
