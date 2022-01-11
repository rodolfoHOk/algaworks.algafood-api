package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("FormasPagamentoModel")
@Getter
@Setter
public class FormasPagamentoModelOpenApi {
	
	private FormasPagamentoEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("FormasPagamentoEmbeddedModel")
	@Getter
	@Setter
	public class FormasPagamentoEmbeddedModelOpenApi {
		
		List<FormaPagamentoModelOpenApi> formasPagamento;
		
	}
}
