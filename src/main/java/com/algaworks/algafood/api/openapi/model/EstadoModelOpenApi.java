package com.algaworks.algafood.api.openapi.model;

import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("EstadoModel")
@Getter
@Setter
public class EstadoModelOpenApi extends RepresentationModel<EstadoModelOpenApi>{
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Minas Gerais")
	private String nome;
	
	@ApiModelProperty(hidden = true)
	private Links links;
	
	private Links _links;
	
}
