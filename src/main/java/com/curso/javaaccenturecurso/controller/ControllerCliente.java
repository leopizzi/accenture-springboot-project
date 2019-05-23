package com.curso.javaaccenturecurso.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.javaaccenturecurso.entidade.Cliente;
import com.curso.javaaccenturecurso.exception.ValidationException;
import com.curso.javaaccenturecurso.model.ClienteModel;
import com.curso.javaaccenturecurso.service.ServiceCliente;

@RestController
@RequestMapping({ "/cliente" })
public class ControllerCliente {

	@Autowired
	private ServiceCliente service;

	@GetMapping
	public Iterable<Cliente> findAll() throws ValidationException {
		Iterable<Cliente> response = service.buscarTodosCliente();
		return response;
	}

	@GetMapping(path = { "/{id}" })
	public Cliente findById(@PathVariable String id) {
		Cliente response = service.buscarClientePeloDocumento(id);
		return response;
	}

	@PostMapping
	public Cliente create(@RequestBody ClienteModel cliente, BindingResult bindingResult) {
		Cliente response = service.cadastrarCliente(cliente);
		return response;
	}

	@DeleteMapping(path = { "/{id}" })
	public Cliente delete(@PathVariable String id) {
		Cliente response = service.deletarCliente(id);
		return response;
	}

	@PutMapping(path = "/{id}")
	public Cliente update(@PathVariable("id") String id, @RequestBody ClienteModel cliente) {
		Cliente response = service.editarCliente(id, cliente);
		return response;
	}
	
	@GetMapping(path = {"/{id}/existe"})
	public boolean existeCliente(@PathVariable("id") String id) {
		return service.existeCliente(id);
	}
}


