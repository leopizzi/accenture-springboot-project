package com.curso.javaaccenturecurso.entidade;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CLIENTE", schema = "")
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "DOCUMENTO", nullable = false, precision = 15)
    private String documento;

    @Column(name = "NOME", nullable = false, precision = 256)
    private String nome;

    @Column(name = "TELEFONE", nullable = false, precision = 15)
    private String telefone;

    @Column(name = "EMAIL", nullable = false, precision = 256)
    private String email;

    @Column(name = "ENDERECO", nullable = false, precision = 256)
    private String endereco;

}
