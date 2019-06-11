package com.curso.javaaccenturecurso.converter;

import com.curso.javaaccenturecurso.entidade.Cliente;
import com.curso.javaaccenturecurso.model.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ClienteModelFromCliente {


    public Cliente convert(ClienteModel model) {

        Cliente response = new Cliente();
        response.setDocumento(model.getDocumento());
        response.setEmail(model.getEmail());
        response.setEndereco(model.getEndereco());
        response.setNome(model.getNome());
        response.setTelefone(model.getTelefone());
        return response;
    }

}
