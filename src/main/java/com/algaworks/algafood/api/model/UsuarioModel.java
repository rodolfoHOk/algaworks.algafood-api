package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {
	
	@ApiModelProperty(example = "6")
	private Long id;
	
	@ApiModelProperty(example = "Débora Mendonça")
	private String nome;
	
	@ApiModelProperty(example = "deboramendonca@gmail.com")
	private String email;
	
}
