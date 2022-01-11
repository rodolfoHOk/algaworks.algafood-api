package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("GruposModel")
@Getter
@Setter
public class GruposModelOpenApi {
	
	private GruposEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("GruposEmbeddedModel")
	@Getter
	@Setter
	public class GruposEmbeddedModelOpenApi {
		
		List<GrupoModelOpenApi> grupos;
		
	}
}
