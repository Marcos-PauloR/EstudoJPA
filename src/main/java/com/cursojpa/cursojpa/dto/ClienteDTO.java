package com.cursojpa.cursojpa.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.cursojpa.cursojpa.domain.Cliente;
import com.cursojpa.cursojpa.service.validation.ClienteUpdate;

import org.hibernate.validator.constraints.Length;

@ClienteUpdate
public class ClienteDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo Obrigatorio.")
    @Length(min = 3, max = 250, message = "Tamanho minimo de: 3 e menor que 250.")
    private String nome;
    
    @NotEmpty(message = "Campo Obrigatorio.")
    @Email(message = "Email Invalido.")
    private String email;

    public ClienteDTO(){
    }

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
