package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

// Limitando os campos retornados pela API com @JsonFilter do Jackson
// @JsonFilter("pedidoFilter") 
@Getter
@Setter
public class PedidoResumoModel {

	private String codigo;
	private BigDecimal subtotal;
	private BigDecimal taxaFrete;
	private BigDecimal valorTotal;
	private String status;
	private OffsetDateTime dataCriacao;
	private RestauranteResumoModel restaurante;
	private UsuarioModel cliente; 
//	private String nomeCliente; // Implementando um conversor de propriedades de ordenação
	
}
