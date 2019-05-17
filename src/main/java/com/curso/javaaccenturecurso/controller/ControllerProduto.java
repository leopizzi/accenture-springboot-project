package com.curso.javaaccenturecurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;
import com.curso.javaaccenturecurso.service.ServiceProduto;

@RestController
@RequestMapping({ "/produto" })
public class ControllerProduto {

	@Autowired
	private ServiceProduto service;

	@GetMapping
	public Iterable<Produto> findAll() {
		Iterable<Produto> response = service.buscarTodosProdutos();
		return response;
	}

	@GetMapping(path = { "/{id}" })
	public Produto findById(@PathVariable long id) {
		Produto response = service.buscarProdutoPeloId(id);
		return response;
	}

	@PostMapping
	public Produto create(@RequestBody ProdutoModel produto) {
		Produto response = service.cadastrarProduto(produto);
		return response;
	}

	@DeleteMapping(path = { "/{id}" })
	public Produto delete(@PathVariable long id) {
		Produto response = service.deletarProduto(id);
		return response;
	}
	
	@PutMapping(path = {"/{id}"})
	public Produto update(@PathVariable long id, @RequestBody ProdutoModel produto) {
		Produto response = service.editarProduto(id, produto);
		return response;
	}
}
