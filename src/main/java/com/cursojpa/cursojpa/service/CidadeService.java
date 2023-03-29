package com.cursojpa.cursojpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojpa.cursojpa.domain.Cidade;
import com.cursojpa.cursojpa.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository repo;


    public List<Cidade> findByEstado(Integer estadoId){
        return repo.findCidades(estadoId);
    }

}