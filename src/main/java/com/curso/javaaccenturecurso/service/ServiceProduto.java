package com.curso.javaaccenturecurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.javaaccenturecurso.converter.ProdutoModelFromProduto;
import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;
import com.curso.javaaccenturecurso.repository.ProdutoRepository;

@Service
public class ServiceProduto {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private ProdutoModelFromProduto produtoModelFromProduto;

	public Iterable<Produto> buscarTodosProdutos() {
		Iterable<Produto> listCliente = repository.findAll();
		return listCliente;
	}

	public Produto buscarProdutoPeloId(long id) {
		Produto response = repository.findByIdProduto(id);
		return response;
	}

	public Produto cadastrarProduto(ProdutoModel produto) {
		Produto conversaoProdutoModelProduto = produtoModelFromProduto.convert(produto);
		Produto response = repository.save(conversaoProdutoModelProduto);
		return response;
	}

	public Produto deletarProduto(long id) {
		Produto response = repository.findByIdProduto(id);
		repository.delete(response);
		return response;

	}

	public Produto editarProduto(long id, ProdutoModel produtoModel) {
		Produto buscaId = repository.findByIdProduto(id);
		Produto response = new Produto();
		if (buscaId != null) {
			Produto conversaoProduto = produtoModelFromProduto.convert(produtoModel);
			conversaoProduto.setIdProduto(id);
			response = repository.save(conversaoProduto);
		}
		return response;
	}

}
