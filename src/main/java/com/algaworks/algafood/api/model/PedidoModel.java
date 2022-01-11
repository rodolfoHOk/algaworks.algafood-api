package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoModel extends RepresentationModel<PedidoModel>{

	private String codigo;
	private BigDecimal subtotal;
	private BigDecimal taxaFrete;
	private BigDecimal valorTotal;
	private String status;
	private OffsetDateTime dataCriacao;
	private OffsetDateTime dataConfirmacao;
	private OffsetDateTime dataEntrega;
	private OffsetDateTime dataCancelamento;
	
	private EnderecoModel endereco;
	private RestauranteApenasNomeModel restaurante;
	private UsuarioModel cliente;
	private List<ItemPedidoModel> itens;
	private FormaPagamentoModel formaPagamento;
	
}
