package com.cursojpa.cursojpa.repository;

import com.cursojpa.cursojpa.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{
    
}
