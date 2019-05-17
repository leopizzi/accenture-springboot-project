package com.curso.javaaccenturecurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.javaaccenturecurso.entidade.Pedido;
import com.curso.javaaccenturecurso.repository.PedidoRepository;

@Service
public class ServicePedido {

	@Autowired
	private PedidoRepository repository;
	
	public Iterable<Pedido> buscarTodosOsProdutos() {
	Iterable<Pedido> response = repository.findAll();
	
	return response;
	}

}
