package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResumoModel extends RepresentationModel<CidadeResumoModel>{
	
	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "Campinas")
	private String nome;
	
	@Schema(example = "São Paulo")
	private String estado;
	
}
