package com.cursojpa.cursojpa.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.cursojpa.cursojpa.service.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTIO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo Obrigatorio.")
    @Length(min = 3, max = 250, message = "Tamanho minimo de: 3 e menor que 250.")
    private String nome;


    @NotEmpty(message = "Campo Obrigatorio.")
    @Email(message = "Email Invalido.")
    private String email;
    
    @NotEmpty(message = "Campo Obrigatorio.")
    private String cpfOuCnpj;
    private Integer tipo;


    @NotEmpty(message = "Campo Obrigatorio.")
    private String senha;

    @NotEmpty(message = "Campo Obrigatorio.")
    private String logradouro;

    @NotEmpty(message = "Campo Obrigatorio.")
    private String numero;
    
    private String complemento;
    private String bairro;
    
    @NotEmpty(message = "Campo Obrigatorio.")
    private String cep;

    @NotEmpty(message = "Campo Obrigatorio.")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer CidadeId;

    public ClienteNewDTIO() {

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

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public Integer getCidadeId() {
        return CidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        CidadeId = cidadeId;
    }

}
