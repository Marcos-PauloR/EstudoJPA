
package com.cursojpa.cursojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cursojpa.cursojpa.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
    
    @Transactional(readOnly=true)
    @Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
    List<Cidade> findCidades(@Param("estadoId") Integer estado_id);

}
