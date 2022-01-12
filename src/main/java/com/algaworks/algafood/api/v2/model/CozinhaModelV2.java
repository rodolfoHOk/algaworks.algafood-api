package com.algaworks.algafood.api.v2.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "cozinhas")
@Getter
@Setter
public class CozinhaModelV2 extends RepresentationModel<CozinhaModelV2> {
	
	private Long idCozinha;
	private String nomeCozinha;
	
}
