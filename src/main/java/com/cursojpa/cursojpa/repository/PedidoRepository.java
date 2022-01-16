package com.cursojpa.cursojpa.repository;

import com.cursojpa.cursojpa.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{
    
}
