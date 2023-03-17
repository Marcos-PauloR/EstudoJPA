package com.cursojpa.cursojpa.dto;

import java.io.Serializable;

import com.cursojpa.cursojpa.domain.Produto;

public class ProdutoDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private Double preço;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer id, String nome, Double preço) {
        this.id = id;
        this.nome = nome;
        this.preço = preço;
    }

    public ProdutoDTO(Produto obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preço = obj.getPreço();
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

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    
}
