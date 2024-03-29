package com.cursojpa.cursojpa.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cursojpa.cursojpa.domain.Cliente;
import com.cursojpa.cursojpa.domain.Pedido;

public abstract class AbstractEmailService implements EmailService{
    
    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

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

    protected String htmlFromTemplatePedido(Pedido pedido){
        Context context = new Context();

        context.setVariable("pedido", pedido);
        return templateEngine.process("email/confirmacaoPedido", context);
    }

    @Override
    public void sendOrderConfirmationEmailHtmlEmail(Pedido pedido){
        try{
            MimeMessage mm = prepareMimeMessageFromPedido(pedido);
            sendHtmlEmail(mm);        
        }catch(MessagingException e){
            sendOrderConfirmationEmail(pedido);
        }
    }

    private MimeMessage prepareMimeMessageFromPedido(Pedido pedido) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(pedido.getCliente().getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Pedido Confirmado! Codigo"+pedido.getId());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplatePedido(pedido), true);
        return mimeMessage;
    }

    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(cliente.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de ALteração de Senha!");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova Senha: "+newPass);
        return sm;
    }


}
