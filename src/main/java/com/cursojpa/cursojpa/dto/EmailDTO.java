package com.cursojpa.cursojpa.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO implements Serializable{
    

    @Email
    @NotEmpty(message  = "Email obrigatorio")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmailDTO(String email) {
        this.email = email;
    }

    public EmailDTO() {
       
    }
   

}
