package com.cursojpa.cursojpa.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojpa.cursojpa.domain.ItemPedido;
import com.cursojpa.cursojpa.domain.PagamentoComBoleto;
import com.cursojpa.cursojpa.domain.Pedido;
import com.cursojpa.cursojpa.domain.enums.EstadoPagamento;
import com.cursojpa.cursojpa.repository.ItemPedidoRepository;
import com.cursojpa.cursojpa.repository.PagamentoRepository;
import com.cursojpa.cursojpa.repository.PedidoRepository;
import com.cursojpa.cursojpa.service.exceptions.ObjectNotFoundException;

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
    private ClienteService clienteservice;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private EmailService emailService;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
            "Objeto não encontrado! Id: "+ id+", Tipo: "+Pedido.class.getName()));
    }

    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteservice.find(obj.getCliente().getId()));
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
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreço());
            ip.setPedido(obj);
        }

        itemPedidoRepository.saveAll(obj.getItens());


        emailService.sendOrderConfirmationEmail(obj);
        return obj;
    }
}