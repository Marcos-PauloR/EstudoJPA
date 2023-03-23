package com.cursojpa.cursojpa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cursojpa.cursojpa.domain.Categoria;
import com.cursojpa.cursojpa.domain.Cidade;
import com.cursojpa.cursojpa.domain.Cliente;
import com.cursojpa.cursojpa.domain.Endereco;
import com.cursojpa.cursojpa.domain.Estado;
import com.cursojpa.cursojpa.domain.ItemPedido;
import com.cursojpa.cursojpa.domain.Pagamento;
import com.cursojpa.cursojpa.domain.PagamentoComBoleto;
import com.cursojpa.cursojpa.domain.PagamentoComCartao;
import com.cursojpa.cursojpa.domain.Pedido;
import com.cursojpa.cursojpa.domain.Produto;
import com.cursojpa.cursojpa.domain.enums.EstadoPagamento;
import com.cursojpa.cursojpa.domain.enums.Perfil;
import com.cursojpa.cursojpa.domain.enums.TipoCliente;
import com.cursojpa.cursojpa.repository.CategoriaRepository;
import com.cursojpa.cursojpa.repository.CidadeRepository;
import com.cursojpa.cursojpa.repository.ClienteRepository;
import com.cursojpa.cursojpa.repository.EnderecoRepository;
import com.cursojpa.cursojpa.repository.EstadoRepository;
import com.cursojpa.cursojpa.repository.ItemPedidoRepository;
import com.cursojpa.cursojpa.repository.PagamentoRepository;
import com.cursojpa.cursojpa.repository.PedidoRepository;
import com.cursojpa.cursojpa.repository.ProdutoRepository;

@Service
public class DBService {
    
    @Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

public void instanciateDatabase() throws ParseException{
    Categoria cat1 = new Categoria(null, "Informatica");
    Categoria cat2 = new Categoria(null, "Escritorio");
    Categoria cat3 = new Categoria(null, "Cama mesa e banho");
    Categoria cat4 = new Categoria(null, "Eletronicos");
    Categoria cat5 = new Categoria(null, "Jardinagem");
    Categoria cat6 = new Categoria(null, "Decoração");
    Categoria cat7 = new Categoria(null, "Perfumaria");

    Produto prod1 = new Produto(null, "Computador", 2000.00);
    Produto prod2 = new Produto(null, "Impressora", 800.00);
    Produto prod3 = new Produto(null, "Mouse", 80.00);
    Produto prod4 = new Produto(null, "Mesa de Escritorio", 300.00);
    Produto prod5 = new Produto(null, "Toalha", 50.00);
    Produto prod6 = new Produto(null, "Colcha", 200.00);
    Produto prod7 = new Produto(null, "Tv true Color", 1200.00);
    Produto prod8 = new Produto(null, "Roçadera", 800.00);
    Produto prod9 = new Produto(null, "Abajour", 100.00);
    Produto prod10 = new Produto(null, "Pendente", 180.00);
    Produto prod11 = new Produto(null, "Shampoo", 90.00);

    cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
    cat2.getProdutos().addAll(Arrays.asList(prod2, prod4));
    cat3.getProdutos().addAll(Arrays.asList(prod5, prod6));
    cat4.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3, prod7));
    cat5.getProdutos().addAll(Arrays.asList(prod8));
    cat6.getProdutos().addAll(Arrays.asList(prod9, prod10));
    cat7.getProdutos().addAll(Arrays.asList(prod11));

    prod1.getCategorias().addAll(Arrays.asList(cat1, cat4));
    prod2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
    prod3.getCategorias().addAll(Arrays.asList(cat1, cat4));
    prod4.getCategorias().addAll(Arrays.asList(cat2));
    prod5.getCategorias().addAll(Arrays.asList(cat3));
    prod6.getCategorias().addAll(Arrays.asList(cat3));
    prod7.getCategorias().addAll(Arrays.asList(cat4));
    prod8.getCategorias().addAll(Arrays.asList(cat5));
    prod9.getCategorias().addAll(Arrays.asList(cat6));
    prod10.getCategorias().addAll(Arrays.asList(cat6));
    prod11.getCategorias().addAll(Arrays.asList(cat7));


    categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
    produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11));

    Estado est1 = new Estado(null, "Minas Gerais");
    Estado est2 = new Estado(null, "São Paulo");


    Cidade cid1 = new Cidade(null, "Uberlândia", est1);
    Cidade cid2 = new Cidade(null, "São Paulo", est2);
    Cidade cid3 = new Cidade(null, "Campinas", est2);

    est1.getCidades().addAll(Arrays.asList(cid1));
    est2.getCidades().addAll(Arrays.asList(cid2, cid3));
    
    estadoRepository.saveAll(Arrays.asList(est1, est2));
    cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));


    Cliente cli1 = new Cliente(null, "Maria Silva", "daegon320@gmail.com", "12345678900", TipoCliente.PESSOAFISICA, pe.encode("123"));
    Cliente cli2 = new Cliente(null, "Anta Costa", "asdasd@gmail.com", "04241523048", TipoCliente.PESSOAFISICA, pe.encode("123"));
    cli2.addPerfil(Perfil.ADMIN);
    cli1.getTelefones().addAll(Arrays.asList("912345678", "987654321"));
    cli2.getTelefones().addAll(Arrays.asList("912345678", "643515316"));

    Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 341", "Jardim","74000000", cli1, cid1); 
    Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "centro", "74000000", cli1, cid2);
    Endereco e3 = new Endereco(null, "Avenida T63", "105", "sala 800", "marista", "74000000", cli2, cid2);

    cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
    cli2.getEnderecos().addAll(Arrays.asList(e3));


    clienteRepository.saveAll(Arrays.asList(cli1, cli2));
    enderecoRepository.saveAll(Arrays.asList(e1,e2));
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    Pedido ped1 = new Pedido(null, sdf.parse("30/09/2021 10:32"), cli1, e1); 
    Pedido ped2 = new Pedido(null, sdf.parse("10/10/2021 20:14"), cli1, e2);

    Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
    ped1.setPagamento(pagto1);
    Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2023 12:00"), null);
    ped2.setPagamento(pagto2);

    cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
    
    pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
    pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));


    ItemPedido ip1 = new ItemPedido(ped1, prod1, 0.00, 1, 2000.00);
    ItemPedido ip2 = new ItemPedido(ped1, prod3, 0.00, 2, 80.00);
    ItemPedido ip3 = new ItemPedido(ped2, prod2, 100.00, 1, 800.00);

    ped1.getItens().addAll(Arrays.asList(ip1, ip2));
    ped2.getItens().addAll(Arrays.asList(ip3));

    prod1.getItens().addAll(Arrays.asList(ip1));
    prod2.getItens().addAll(Arrays.asList(ip3));
    prod3.getItens().addAll(Arrays.asList(ip2));

    itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

}

}
