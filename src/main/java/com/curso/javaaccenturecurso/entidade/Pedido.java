package com.curso.javaaccenturecurso.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PEDIDO")
@Data
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA", nullable = false)
    public Date dataPedido;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DOCUMENTO")
    public Cliente cliente;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUTO")
    public Produto produto;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_NUMEROSEQUENCIALPEDIDO_GENERATOR")
    @SequenceGenerator(sequenceName = "SQ_PEDIDO", allocationSize = 1, name = "PEDIDO_NUMEROSEQUENCIALPEDIDO_GENERATOR")
    @Column(name = "NUMERO", nullable = false, precision = 15)
    private long numeroPedido;
    @Column(name = "STATUS", nullable = true, precision = 15)
    private String status;
    @Column(name = "VALOR_TOTAL", nullable = true, precision = 15)
    private BigDecimal valorTotal;
    @Column(name = "QUANTIDADE", nullable = true, precision = 15)
    private Integer quantidade;
}
