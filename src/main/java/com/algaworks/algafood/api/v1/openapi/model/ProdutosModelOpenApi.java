package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("ProdutosModel")
@Getter
@Setter
public class ProdutosModelOpenApi {
	
	private ProdutosEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("ProdutosEmbeddedModel")
	@Getter
	@Setter
	public class ProdutosEmbeddedModelOpenApi {
		
		List<ProdutoModelOpenApi> produtos;
		
	}
}
