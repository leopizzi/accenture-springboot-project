package com.curso.javaaccenturecurso.converter;

import org.springframework.stereotype.Component;

import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;

@Component
public class ProdutoModelFromProduto {
	
	
	public Produto convert(ProdutoModel model) {
		
		Produto response = new Produto();
		response.setDescricao(model.getDescricao());
		response.setValor(model.getValor());
		
		return response;
	}
}
