package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "restaurantes")
@Getter
@Setter
public class RestauranteBasicoModel extends RepresentationModel<RestauranteBasicoModel>{
	
	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "Thai Gourmet")
	private String nome;
	
	@Schema(example = "5.50")
	private BigDecimal taxaFrete;
	
	private CozinhaModel cozinha;
	
}
