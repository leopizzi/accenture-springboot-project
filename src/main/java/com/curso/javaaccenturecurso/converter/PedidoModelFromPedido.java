package com.curso.javaaccenturecurso.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.javaaccenturecurso.entidade.Pedido;
import com.curso.javaaccenturecurso.model.PedidoModel;
import com.curso.javaaccenturecurso.repository.ClienteRepository;
import com.curso.javaaccenturecurso.repository.ProdutoRepository;

@Component
public class PedidoModelFromPedido {
	
	//VERIFICAR SE É BOA PRÁTICA COLOCAR OS REPOSITORYS AQUI.

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public Pedido convert(PedidoModel pedidoModel) {
		Pedido pedido = new Pedido();
		pedido.setCliente(clienteRepository.findByDocumento(pedidoModel.getDocumentoCliente()));
		pedido.setProduto(produtoRepository.findByIdProduto(pedidoModel.getNumeroPedido()));
		pedido.setDataPedido(pedidoModel.getDataPedido());
		pedido.setQuantidade(pedidoModel.getQuantidade());
		pedido.setStatus(pedidoModel.getStatus());
		pedido.setValorTotal(pedidoModel.getValorTotal());

		return pedido;
	}
}
