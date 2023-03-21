package com.cursojpa.cursojpa.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojpa.cursojpa.service.DBService;
import com.cursojpa.cursojpa.service.EmailService;
import com.cursojpa.cursojpa.service.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBService dbservice;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciateDatabase() throws ParseException{
        if(!"create".equals(strategy)){
            return false;
        }
        dbservice.instanciateDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }

}
