package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PermissoesModel")
@Getter
@Setter
public class PermissoesModelOpenApi {
	
	private PermissoesEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("PermissoesEmbeddedModel")
	@Getter
	@Setter
	public class PermissoesEmbeddedModelOpenApi {
		
		List<PermissaoModelOpenApi> permissoes;
		
	}

}
