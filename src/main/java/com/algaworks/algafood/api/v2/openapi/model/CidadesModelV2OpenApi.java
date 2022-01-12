package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CidadesModel")
@Getter
@Setter
public class CidadesModelV2OpenApi {
	
	private CidadeEmbeddedModelV2OpenApi _embedded;
	private Links _links;

	@ApiModel("CidadesEmbeddedModel")
	@Getter
	@Setter
	public class CidadeEmbeddedModelV2OpenApi {
		
		private List<CidadeModelV2OpenApi> cidades;
		
	}
}
