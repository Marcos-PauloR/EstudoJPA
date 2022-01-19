package com.cursojpa.cursojpa.service;

import java.util.Optional;

import com.cursojpa.cursojpa.domain.Cliente;
import com.cursojpa.cursojpa.repository.ClienteRepository;
import com.cursojpa.cursojpa.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
            "Objeto não encontrado! Id: "+ id+", Tipo: "+Cliente.class.getName()));
    }

}
