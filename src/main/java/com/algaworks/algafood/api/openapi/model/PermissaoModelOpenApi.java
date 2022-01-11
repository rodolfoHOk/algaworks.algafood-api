package com.algaworks.algafood.api.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PermissaoModel")
@Getter
@Setter
public class PermissaoModelOpenApi {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "CONSULTAR_COZINHAS")
	private String nome;
	
	@ApiModelProperty(example = "Permite consultar cozinhas")
	private String descricao;
	
	private Links _links;
	
}
