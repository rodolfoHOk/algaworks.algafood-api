package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

// @ApiModel(value = "Cidade", description = "Representa uma cidade")
@ApiModel(description = "Representa uma cidade")
@Getter
@Setter
public class CidadeModel {
	
//	@ApiModelProperty(value = "ID da cidade", example = "1")
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Uberlândia")
	private String nome;
	
	private EstadoModel estado;
	
}
