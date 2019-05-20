package com.curso.javaaccenturecurso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.javaaccenturecurso.entidade.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	Pedido findByNumeroPedido(long id);
}
