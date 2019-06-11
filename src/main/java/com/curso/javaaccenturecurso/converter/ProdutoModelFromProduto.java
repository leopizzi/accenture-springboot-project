package com.curso.javaaccenturecurso.converter;

import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoModelFromProduto {


    public Produto convert(ProdutoModel model) {

        Produto response = new Produto();
        response.setDescricao(model.getDescricao());
        response.setValor(model.getValor());

        return response;
    }
}
