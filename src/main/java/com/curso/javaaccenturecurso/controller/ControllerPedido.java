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

import com.curso.javaaccenturecurso.entidade.Pedido;
import com.curso.javaaccenturecurso.model.PedidoModel;
import com.curso.javaaccenturecurso.service.ServicePedido;

@RestController
@RequestMapping({ "/pedido" })
public class ControllerPedido {
	@Autowired
	private ServicePedido service;

	@GetMapping
	public Iterable<Pedido> findAll() {
		Iterable<Pedido> response = service.buscarTodosPedidos();
		return response;
	}

	@GetMapping(path = { "/{id}" })
	public Pedido findById(@PathVariable long id) {
		Pedido response = service.buscaPedidoPorId(id);
		return response;
	}

	@PostMapping
	public Pedido create(@RequestBody PedidoModel pedido) {
		Pedido response = service.criarPedido(pedido);
		return response;
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Pedido delete(@PathVariable long id) {
		Pedido response = service.deletarProduto(id);
		return response;
	}
	
	@PutMapping
	public Pedido update (@RequestBody PedidoModel pedido) {
		Pedido response = service.updatePedido(pedido);
		return response;
	}
}