package com.algaworks.algafood.api.openapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.EnderecoModel;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.model.UsuarioModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PedidoModel")
@Getter
@Setter
public class PedidoModelOpenApi {

	@ApiModelProperty(example = "f9981ca4-5a5e-4da3-af04-933861df3e55")
	private String codigo;
	
	@ApiModelProperty(example = "298.90")
	private BigDecimal subtotal;
	
	@ApiModelProperty(example = "10.00")
	private BigDecimal taxaFrete;
	
	@ApiModelProperty(example = "308.90")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(example = "CRIADO")
	private String status;
	
	@ApiModelProperty(example = "2022-01-05T02:46:51Z")
	private OffsetDateTime dataCriacao;
	
	@ApiModelProperty(example = "2022-01-05T02:46:51Z")
	private OffsetDateTime dataConfirmacao;
	
	@ApiModelProperty(example = "2022-01-05T02:46:51Z")
	private OffsetDateTime dataEntrega;
	
	@ApiModelProperty(example = "2022-01-05T02:46:51Z")
	private OffsetDateTime dataCancelamento;
	
	private EnderecoModel endereco;
	private RestauranteApenasNomeModel restaurante;
	private UsuarioModel cliente;
	
	private List<ItemPedidoModelOpenApi> itens;
	private FormaPagamentoModel formaPagamento;
	
	private Links _links;
	
}
