package com.cursojpa.cursojpa.service;

import java.util.List;
import java.util.Optional;

import com.cursojpa.cursojpa.domain.Categoria;
import com.cursojpa.cursojpa.repository.CategoriaRepository;
import com.cursojpa.cursojpa.service.exceptions.DataIntegrityException;
import com.cursojpa.cursojpa.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
            "Objeto não encontrado! Id: "+id+", Tipo: "+Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try{
            repository.deleteById(id); 
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir Categoria que possui Produtos");
        }
        
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
}
