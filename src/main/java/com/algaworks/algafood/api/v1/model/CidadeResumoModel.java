package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResumoModel extends RepresentationModel<CidadeResumoModel>{
	
	private Long id;
	private String nome;
	private String estado;
	
}
