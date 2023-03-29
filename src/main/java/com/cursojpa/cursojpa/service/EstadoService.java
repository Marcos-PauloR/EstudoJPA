package com.cursojpa.cursojpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojpa.cursojpa.domain.Estado;
import com.cursojpa.cursojpa.repository.EstadoRepository;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository repo;

    public List<Estado> findAll(){
        return repo.findAllByOrderByNome();
    }

}
