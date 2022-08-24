package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "formas-pagamento")
@Getter
@Setter
public class FormaPagamentoModel extends RepresentationModel<FormaPagamentoModel>{
	
	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "Cartão de crédito")
	private String descricao;
	
}
