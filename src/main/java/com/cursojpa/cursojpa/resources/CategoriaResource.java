package com.cursojpa.cursojpa.resources;

import com.cursojpa.cursojpa.domain.Categoria;
import com.cursojpa.cursojpa.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categoria/")
public class CategoriaResource{

    @Autowired
    private CategoriaService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }



}