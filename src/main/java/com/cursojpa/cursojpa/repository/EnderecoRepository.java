package com.cursojpa.cursojpa.repository;

import com.cursojpa.cursojpa.domain.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer>{
    
}
