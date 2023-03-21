package com.cursojpa.cursojpa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.cursojpa.cursojpa.domain.Pedido;

public abstract class AbstractEmailService implements EmailService{
    
    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Pedido pedido){
        SimpleMailMessage sm = prepareSimpleMailFromPredido(pedido);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailFromPredido(Pedido pedido) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(pedido.getCliente().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Confirmação de Pedido! Código: "+pedido.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(pedido.toString());
        return sm;
    }
}
