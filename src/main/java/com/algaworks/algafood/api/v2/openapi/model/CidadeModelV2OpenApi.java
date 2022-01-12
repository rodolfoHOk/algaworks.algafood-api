package com.algaworks.algafood.api.v2.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CidadeModel")
@Getter
@Setter
public class CidadeModelV2OpenApi {
	
	@ApiModelProperty(example = "1")
	private Long idCidade;
	
	@ApiModelProperty(example = "Uberlândia")
	private String nomeCidade;
	
	@ApiModelProperty(example = "2")
	private Long idEstado;
	
	@ApiModelProperty(example = "Minas Gerais")
	private String nomeEstado;
	
	private Links _links;
	
}
