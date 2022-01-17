package com.cursojpa.cursojpa.repository;

import com.cursojpa.cursojpa.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer>{
    
}
