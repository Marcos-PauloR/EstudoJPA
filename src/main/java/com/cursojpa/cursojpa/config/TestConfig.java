package com.cursojpa.cursojpa.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojpa.cursojpa.service.DBService;
import com.cursojpa.cursojpa.service.EmailService;
import com.cursojpa.cursojpa.service.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
    
    @Autowired
    private DBService dbservice;

    @Bean
    public boolean instanciateDatabase() throws ParseException{
        dbservice.instanciateDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
