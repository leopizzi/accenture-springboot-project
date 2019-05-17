package com.curso.javaaccenturecurso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.javaaccenturecurso.entidade.Pedido;
import com.curso.javaaccenturecurso.service.ServicePedido;

@RestController
@RequestMapping(path = { "/pedido" })
public class ControllerPedido {

	private ServicePedido service;

	@GetMapping
	public Iterable<Pedido> findAll() {
		Iterable<Pedido> response = service.buscarTodosOsProdutos();
		return response;
	}
}