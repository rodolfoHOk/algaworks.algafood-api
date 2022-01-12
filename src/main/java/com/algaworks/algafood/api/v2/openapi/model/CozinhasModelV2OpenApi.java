package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("CozinhasModel")
@Getter
@Setter
public class CozinhasModelV2OpenApi {
	
	private CozinhasEmbeddedModelV2OpenApi _embedded;
	private Links _links;
	private PageModelV2OpenApi page;
	
	@ApiModel("CozinhasEmbeddedModel")
	@Getter
	@Setter
	public class CozinhasEmbeddedModelV2OpenApi {
		
		List<CozinhaModelV2OpenApi> cozinhas;
		
	}
}
