package com.curso.javaaccenturecurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.javaaccenturecurso.converter.PedidoModelFromPedido;
import com.curso.javaaccenturecurso.entidade.Pedido;
import com.curso.javaaccenturecurso.model.PedidoModel;
import com.curso.javaaccenturecurso.repository.PedidoRepository;

@Service
public class ServicePedido {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private PedidoModelFromPedido conversaoPedido;

	public Iterable<Pedido> buscarTodosPedidos() {
		Iterable<Pedido> response = repository.findAll();
		return response;
	}

	public Pedido buscaPedidoPorId(long id) {
		Pedido response = repository.findByNumeroPedido(id);
		return response;
	}

	public Pedido criarPedido(PedidoModel pedidoModel) {
		Pedido response = conversaoPedido.convert(pedidoModel);
		repository.save(response);
		return response;
	}

	public Pedido deletarProduto(long id) {
		Pedido response = repository.findByNumeroPedido(id);
		repository.delete(response);
		return response;
	}

	public Pedido updatePedido(PedidoModel pedidoModel) {
		Pedido buscaPorId = repository.findByNumeroPedido(pedidoModel.getIdProduto());
		Pedido response = new Pedido();
		if (buscaPorId != null) {
			response = conversaoPedido.convert(pedidoModel);
			response.setNumeroPedido(pedidoModel.getNumeroPedido());
			repository.save(response);
		}
		return response;
	}
}