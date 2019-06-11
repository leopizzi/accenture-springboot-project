package com.curso.javaaccenturecurso.controller;

import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;
import com.curso.javaaccenturecurso.service.ServiceProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/produto"})
public class ControllerProduto {

    @Autowired
    private ServiceProduto service;

    @GetMapping
    public Iterable<Produto> findAll() {
        Iterable<Produto> response = service.buscarTodosProdutos();
        return response;
    }

    @GetMapping(path = {"/{id}"})
    public Produto findById(@PathVariable long id) {
        Produto response = service.buscarProdutoPeloId(id);
        return response;
    }

    @PostMapping
    public Produto create(@RequestBody ProdutoModel produto) {
        Produto response = service.cadastrarProduto(produto);
        return response;
    }

    @DeleteMapping(path = {"/{id}"})
    public Produto delete(@PathVariable long id) {
        Produto response = service.deletarProduto(id);
        return response;
    }

    @PutMapping(path = {"/{id}"})
    public Produto update(@PathVariable long id, @RequestBody ProdutoModel produto) {
        Produto response = service.editarProduto(id, produto);
        return response;
    }
}
