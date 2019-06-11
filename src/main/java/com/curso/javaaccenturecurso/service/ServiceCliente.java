package com.curso.javaaccenturecurso.service;

import com.curso.javaaccenturecurso.converter.ClienteModelFromCliente;
import com.curso.javaaccenturecurso.entidade.Cliente;
import com.curso.javaaccenturecurso.model.ClienteModel;
import com.curso.javaaccenturecurso.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCliente {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteModelFromCliente clienteModelFromCliente;

    public Iterable<Cliente> buscarTodosCliente() {

        Iterable<Cliente> listCliente = repository.findAll();
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
        ClienteModel cliente = null;
        try {
            cliente = rest.getForObject("https://springboot-leo.herokuapp.com/cliente/" + id, ClienteModel.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        if (cliente == null)
            return false;
        return true;
    }

}
