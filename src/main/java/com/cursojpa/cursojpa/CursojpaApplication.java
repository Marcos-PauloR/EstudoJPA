package com.cursojpa.cursojpa;

import java.util.Arrays;

import com.cursojpa.cursojpa.domain.Categoria;
import com.cursojpa.cursojpa.domain.Cidade;
import com.cursojpa.cursojpa.domain.Cliente;
import com.cursojpa.cursojpa.domain.Endereco;
import com.cursojpa.cursojpa.domain.Estado;
import com.cursojpa.cursojpa.domain.Produto;
import com.cursojpa.cursojpa.domain.enums.TipoCliente;
import com.cursojpa.cursojpa.repository.CategoriaRepository;
import com.cursojpa.cursojpa.repository.CidadeRepository;
import com.cursojpa.cursojpa.repository.ClienteRepository;
import com.cursojpa.cursojpa.repository.EnderecoRepository;
import com.cursojpa.cursojpa.repository.EstadoRepository;
import com.cursojpa.cursojpa.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursojpaApplication implements CommandLineRunner {
	
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

	public static void main(String[] args) {
		SpringApplication.run(CursojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");


		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));


		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12345678900", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("912345678", "987654321"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 341", "Jardim","74000000", cli1, cid1); 
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "centro", "74000000", cli1, cid2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));


		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

	}


}
