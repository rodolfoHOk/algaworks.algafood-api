package com.algaworks.algafood.api.openapi.model;

import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CidadeModel")
@Getter
@Setter
public class CidadeModelOpenApi extends RepresentationModel<CidadeModelOpenApi>{
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Uberlândia")
	private String nome;
	
	private EstadoModelOpenApi estado;
	
	@ApiModelProperty(hidden = true)
	private Links links;
	
	private Links _links;
}
