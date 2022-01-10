package com.algaworks.algafood.api.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CidadeModel")
@Getter
@Setter
public class CidadeModelOpenApi {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Uberlândia")
	private String nome;
	
	private EstadoModelOpenApi estado;
	
	private Links _links;
	
}
