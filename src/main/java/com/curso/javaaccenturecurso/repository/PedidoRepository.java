package com.curso.javaaccenturecurso.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import com.curso.javaaccenturecurso.entidade.Pedido;
@Profile("dev")
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
