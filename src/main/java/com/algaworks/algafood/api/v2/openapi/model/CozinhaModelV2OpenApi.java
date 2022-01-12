package com.algaworks.algafood.api.v2.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CozinhaModel")
@Getter
@Setter
public class CozinhaModelV2OpenApi {
	
	@ApiModelProperty(example = "1")
	private Long idCozinha;
	
	@ApiModelProperty(example = "Brasileira")
	private String nomeCozinha;
	
	private Links _links;
	
}
