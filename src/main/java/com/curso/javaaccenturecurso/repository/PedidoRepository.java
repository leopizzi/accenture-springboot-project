package com.curso.javaaccenturecurso.repository;

import com.curso.javaaccenturecurso.entidade.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    Pedido findByNumeroPedido(long id);
}
