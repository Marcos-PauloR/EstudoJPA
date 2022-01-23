package com.cursojpa.cursojpa.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.cursojpa.cursojpa.domain.Categoria;

import org.hibernate.validator.constraints.Length;


public class CategoriaDTO implements Serializable{     
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 250, message = "Campo deve ser entre 3 e 250")
    private String nome;

    public CategoriaDTO(){

    }

    public CategoriaDTO(Categoria categoria){
        this.id=categoria.getId();
        this.nome=categoria.getNome();
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
}
