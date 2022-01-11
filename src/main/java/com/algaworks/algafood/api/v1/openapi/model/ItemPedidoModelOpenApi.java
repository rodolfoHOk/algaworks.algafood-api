package com.algaworks.algafood.api.v1.openapi.model;

import java.math.BigDecimal;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ItemPedidoModel")
@Getter
@Setter
public class ItemPedidoModelOpenApi {

	@ApiModelProperty(example = "1")
	private Long produtoId;

	@ApiModelProperty(example = "Porco com molho agridoce")
	private String produtoNome;

	@ApiModelProperty(example = "2")
	private Integer quantidade;

	@ApiModelProperty(example = "78.90")
	private BigDecimal precoUnitario;

	@ApiModelProperty(example = "157.80")
	private BigDecimal precoTotal;

	@ApiModelProperty(example = "Sem pimenta")
	private String observacao;

	private Links _links;
}
