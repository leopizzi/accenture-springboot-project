package com.curso.javaaccenturecurso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.curso.javaaccenturecurso.entidade.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {

	Cliente findByDocumento(String documento);

}
