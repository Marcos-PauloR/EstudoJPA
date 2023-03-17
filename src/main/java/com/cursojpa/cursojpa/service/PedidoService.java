package com.cursojpa.cursojpa.service;

import java.util.Date;
import java.util.Optional;

import com.cursojpa.cursojpa.domain.ItemPedido;
import com.cursojpa.cursojpa.domain.PagamentoComBoleto;
import com.cursojpa.cursojpa.domain.Pedido;
import com.cursojpa.cursojpa.domain.enums.EstadoPagamento;
import com.cursojpa.cursojpa.repository.ItemPedidoRepository;
import com.cursojpa.cursojpa.repository.PagamentoRepository;
import com.cursojpa.cursojpa.repository.PedidoRepository;
import com.cursojpa.cursojpa.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private BoletoService boletoService; 

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
            "Objeto não encontrado! Id: "+ id+", Tipo: "+Pedido.class.getName()));
    }

    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setInstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if(obj.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());    
        }
        obj = repository.save(obj);

        pagamentoRepository.save(obj.getPagamento());
        for(ItemPedido ip:obj.getItens()){
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreço());
            ip.setPedido(obj);
        }

        itemPedidoRepository.saveAll(obj.getItens());

        return obj;
    }
}