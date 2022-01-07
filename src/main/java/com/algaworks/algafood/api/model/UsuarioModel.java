package com.algaworks.algafood.api.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "usuarios")
@Getter
@Setter
public class UsuarioModel extends RepresentationModel<UsuarioModel> {
	
	@ApiModelProperty(example = "6")
	private Long id;
	
	@ApiModelProperty(example = "Débora Mendonça")
	private String nome;
	
	@ApiModelProperty(example = "deboramendonca@gmail.com")
	private String email;
	
}
