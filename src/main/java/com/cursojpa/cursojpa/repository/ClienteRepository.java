package com.cursojpa.cursojpa.repository;

import com.cursojpa.cursojpa.domain.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT c FROM Cliente c WHERE c.email = ?1 ")
    Cliente findByEmail(String email);

}
