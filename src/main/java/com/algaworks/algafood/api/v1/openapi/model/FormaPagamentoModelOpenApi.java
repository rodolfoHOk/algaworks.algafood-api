package com.algaworks.algafood.api.v1.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("FormaPagamentoModel")
@Getter
@Setter
public class FormaPagamentoModelOpenApi {

	@ApiModelProperty(example = "2")
	private Long id;
	
	@ApiModelProperty(example = "Cartão de Débito")
	private String descricao;
	
	private Links _links;
	
}
