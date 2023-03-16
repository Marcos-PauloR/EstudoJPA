package com.cursojpa.cursojpa.resources;

import com.cursojpa.cursojpa.domain.Pedido;
import com.cursojpa.cursojpa.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/pedido/")
public class PedidoResource{

    @Autowired
    private PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){

        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }



}