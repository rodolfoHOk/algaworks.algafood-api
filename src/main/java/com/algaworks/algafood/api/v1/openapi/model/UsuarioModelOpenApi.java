package com.algaworks.algafood.api.v1.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("UsuarioModel")
@Getter
@Setter
public class UsuarioModelOpenApi {

	@ApiModelProperty(example = "6")
	private Long id;
	
	@ApiModelProperty(example = "Débora Mendonça")
	private String nome;
	
	@ApiModelProperty(example = "deboramendonca@gmail.com")
	private String email;
	
	private Links _links;
	
}
