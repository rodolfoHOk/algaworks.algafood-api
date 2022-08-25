package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "produtos")
public class ProdutoModel extends RepresentationModel<ProdutoModel>{

	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "Porco com molho agridoce")
	private String nome;
	
	@Schema(example = "Lombo de porco assado com molho agridoce levemente apimentado")
	private String descricao;
	
	@Schema(example = "49.50")
	private BigDecimal preco;
	
	@Schema(example = "true")
	private Boolean ativo;
	
}
