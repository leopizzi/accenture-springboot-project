package com.curso.javaaccenturecurso.repository;

import com.curso.javaaccenturecurso.entidade.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    Produto findByIdProduto(long id);

}
