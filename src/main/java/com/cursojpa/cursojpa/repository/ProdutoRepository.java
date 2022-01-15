package com.cursojpa.cursojpa.repository;

import com.cursojpa.cursojpa.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    
}
