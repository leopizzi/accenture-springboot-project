package com.curso.javaaccenturecurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.javaaccenturecurso.converter.ClienteModelFromCliente;
import com.curso.javaaccenturecurso.entidade.Cliente;
import com.curso.javaaccenturecurso.model.ClienteModel;
import com.curso.javaaccenturecurso.repository.ClienteRepository;
import com.curso.javaacenturecurso.exception.ValidationException;

@Service
public class ServiceCliente {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ClienteModelFromCliente clienteModelFromCliente;

	public Iterable<Cliente> buscarTodosCliente() throws ValidationException {

			Iterable<Cliente> listCliente = repository.findAll();
			if (listCliente.iterator().hasNext()) {
				throw new ValidationException("Deu errado.");
			}
			return listCliente;
	}

	public Cliente buscarClientePeloDocumento(String id) {
		Cliente response = repository.findByDocumento(id);
		return response;
	}

	public Cliente cadastrarCliente(ClienteModel clienteModel) {
		Cliente conversaoClienteModelCliente = clienteModelFromCliente.convert(clienteModel);
		Cliente response = repository.save(conversaoClienteModelCliente);
		return response;
	}

	public Cliente deletarCliente(String documento) {
		Cliente response = repository.findByDocumento(documento);
		repository.delete(response);
		return response;
	}

	public Cliente editarCliente(String id, ClienteModel clienteModel) {
		Cliente buscaId = repository.findByDocumento(id);
		Cliente response = new Cliente();
		if (buscaId != null) {
			clienteModel.setDocumento(id);
			Cliente conversaoClienteModelCliente = clienteModelFromCliente.convert(clienteModel);
			response = repository.save(conversaoClienteModelCliente);
		}
		return response;
	}

	public boolean existeCliente(String id) {
		RestTemplate rest = new RestTemplate();
		Cliente cliente = rest.getForObject("https://springboot-leo.herokuapp.com/cliente/" + id, Cliente.class);
		if (cliente == null)
			return false;
		return true;
	}

}
