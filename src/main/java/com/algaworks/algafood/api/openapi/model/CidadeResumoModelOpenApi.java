package com.algaworks.algafood.api.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CidadeResumoModel")
@Getter
@Setter
public class CidadeResumoModelOpenApi {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Uberlândia")
	private String nome;
	
	@ApiModelProperty(example = "Minas Gerais")
	private String estado;
	
	private Links _links;
	
}
