package com.curso.javaaccenturecurso.repository;

import com.curso.javaaccenturecurso.entidade.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {

    Cliente findByDocumento(String documento);
}
