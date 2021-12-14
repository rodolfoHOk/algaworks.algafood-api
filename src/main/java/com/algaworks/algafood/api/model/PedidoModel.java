package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoModel {

	private Long id;
	private BigDecimal subtotal;
	private BigDecimal taxaFrete;
	private BigDecimal valorTotal;
	private OffsetDateTime dataCriacao;
	private OffsetDateTime dataConfirmacao;
	private OffsetDateTime dataCancelamento;
	private OffsetDateTime dataEntrega;
	private String status;
	private EnderecoModel endereco;
	private UsuarioModel cliente;
	private RestauranteResumoModel restaurante;
	private FormaPagamentoModel formaPagamento;
	private List<ItemPedidoModel> itens;
	
}
