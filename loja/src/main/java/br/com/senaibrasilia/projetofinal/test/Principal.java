package br.com.senaibrasilia.projetofinal.test;

import java.math.BigDecimal;
//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.senaibrasilia.projetofinal.dao.CategoriaDao;
import br.com.senaibrasilia.projetofinal.dao.ProdutoDao;
import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class Principal {

	public static void main(String[] args) {

		cadastrarProduto();

//		EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDao produtoDao = new ProdutoDao(em);

//		Produto p = produtoDao.buscarPorId(1l);
//		System.out.println(p.getPreco());

		//List<Produto> todos = produtoDao.buscarPorNome("COMPUTADORES");
		//todos.forEach(p2 -> System.out.println(p.getNome()));

//		List<Produto> precoDoProduto = produtoDao.buscarPorNome("Intel Core i7 9700K");
//		System.out.println("Preço do Produto: " + precoDoProduto);

	}

	private static void cadastrarProduto() {
		
		Categoria processadores = new Categoria("COMPUTADORES");
		Produto processador = new Produto("Intel Core i7 9700K", "Processador de Alto Desempenho", new BigDecimal("2000"), processadores);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		em.persist(processador);
		em.persist(processadores);
//		categoriaDao.cadastrar(processadores);
//		produtoDao.cadastrar(processador);

		em.getTransaction().commit();
		em.close();
	}
}