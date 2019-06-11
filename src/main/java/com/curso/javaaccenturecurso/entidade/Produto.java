package com.curso.javaaccenturecurso.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUTO")
@Data
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_NUMEROSEQUENCIALPRODUTO_GENERATOR")
    @SequenceGenerator(sequenceName = "SQ_PRODUTO", allocationSize = 1, name = "PRODUTO_NUMEROSEQUENCIALPRODUTO_GENERATOR")
    @Column(name = "ID_PRODUTO", nullable = false, precision = 15)
    private long idProduto;

    @Column(name = "DESCRICAO", nullable = false, precision = 256)
    private String descricao;

    @Column(name = "VALOR", nullable = true, precision = 15)
    private long valor;
}
