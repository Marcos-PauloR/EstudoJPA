package com.cursojpa.cursojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojpa.cursojpa.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    

@Transactional(readOnly = true)
List<Estado> findAllByOrderByNome();

}
