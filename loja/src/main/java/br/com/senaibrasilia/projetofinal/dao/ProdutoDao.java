package br.com.senaibrasilia.projetofinal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;

public class ProdutoDao {

	private EntityManager em;

	// Construtor vazio
	public ProdutoDao() {

	}

	// Construtor por sobrecarga
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	// Cadastrar Produto (PERSIST)
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	// Atualizar informações do primeiro Cadastro (MERGE)
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	// Remove os produtos
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

	// Buscar produtos pelo o seu ID único
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);

	}

	// Buscar todos os produtos cadastrados
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();

	}

	public List<Produto> buscarPorNome(String nome) {

		// Variavel JPQL para executar ações no banco
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";

		// Variavel criada com jpql para procurar os produtos desejados
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}

	public List<Produto> buscarPorNomeDaCategoria(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();

	}
}
