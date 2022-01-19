package com.cursojpa.cursojpa.service;

import java.util.Optional;

import com.cursojpa.cursojpa.domain.Pedido;
import com.cursojpa.cursojpa.repository.PedidoRepository;
import com.cursojpa.cursojpa.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repository;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
            "Objeto não encontrado! Id: "+ id+", Tipo: "+Pedido.class.getName()));
    }

}
