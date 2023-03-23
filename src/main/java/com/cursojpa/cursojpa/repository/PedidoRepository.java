package com.cursojpa.cursojpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojpa.cursojpa.domain.Cliente;
import com.cursojpa.cursojpa.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer>{
    
    @Transactional(readOnly  = true)
    Page<Pedido> findByCliente(Cliente cliente, Pageable pageREquest);
}
