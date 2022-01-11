package com.algaworks.algafood.api.v1.openapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.v1.model.UsuarioModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PedidoResumoModel")
@Getter
@Setter
public class PedidoResumoModelOpenApi {

	@ApiModelProperty(example = "f9981ca4-5a5e-4da3-af04-933861df3e55")
	private String codigo;
	
	@ApiModelProperty(example = "298.90")
	private BigDecimal subtotal;
	
	@ApiModelProperty(example = "10.00")
	private BigDecimal taxaFrete;
	
	@ApiModelProperty(example = "308.90")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(example = "CONFIRMADO")
	private String status;
	
	@ApiModelProperty(example = "2022-01-05T03:14:42Z")
	private OffsetDateTime dataCriacao;
	
	private RestauranteApenasNomeModel restaurante;
	private UsuarioModel cliente;
	
	private Links _links;
}
