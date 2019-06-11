package com.curso.javaaccenturecurso.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PedidoModel {

    public String documentoCliente;
    public long idProduto;
    public Date dataPedido;
    private Integer quantidade;
    private BigDecimal valorTotal;
    private String status;
}
