package com.cursojpa.cursojpa.repository;

import com.cursojpa.cursojpa.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    
}
