package com.algaworks.algafood.api.v1.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("RestauranteApenasNomeModel")
@Getter
@Setter
public class RestauranteApenasNomeModelOpenApi {
	
	@ApiModelProperty(example = "2")
	private Long id;
	
	@ApiModelProperty(example = "Thai Delivery")
	private String nome;
	
	private Links _links;
	
}
