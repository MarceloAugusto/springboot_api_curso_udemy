package cursoSpring2.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cursoSpring2.curso.domain.Categoria;
import cursoSpring2.curso.domain.Cidade;
import cursoSpring2.curso.domain.Cliente;
import cursoSpring2.curso.domain.Endereco;
import cursoSpring2.curso.domain.Estado;
import cursoSpring2.curso.domain.Produto;
import cursoSpring2.curso.domain.enums.TipoCliente;
import cursoSpring2.curso.repositories.CategoriaRepository;
import cursoSpring2.curso.repositories.CidadeRepository;
import cursoSpring2.curso.repositories.ClienteRepository;
import cursoSpring2.curso.repositories.EnderecoRepository;
import cursoSpring2.curso.repositories.EstadoRepository;
import cursoSpring2.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpring2Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cateogiraRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpring2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "informática");
		Categoria c2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Mouse", 2000.00);
		Produto p3 = new Produto(null, "Mesa", 2000.00);
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2));
		c2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		cateogiraRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Cliente cli1 = new Cliente(null, "Marcelo", "marceloaugusto16@gmail.com", "34992650016", TipoCliente.PESSOAFISICA);
		cli1.getTelefone().addAll(Arrays.asList("33127574","34992650016"));
		Endereco e1 = new Endereco(null, "Rua Eneias guerra terra", "54","Ap22","Jardin","3805500",cli1,cid1);
		Endereco e2 = new Endereco(null, "Rua Xy", "54","Ap22","Jardin","3805500",cli1,cid1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
