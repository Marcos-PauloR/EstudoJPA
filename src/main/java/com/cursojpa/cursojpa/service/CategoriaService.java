package com.cursojpa.cursojpa.service;

import java.util.Optional;

import com.cursojpa.cursojpa.domain.Categoria;
import com.cursojpa.cursojpa.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElse(null);
    }

}
