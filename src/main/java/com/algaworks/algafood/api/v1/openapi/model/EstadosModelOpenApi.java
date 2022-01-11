package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("EstadosModel")
@Getter
@Setter
public class EstadosModelOpenApi {
	
	private EstadosEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("EstadosEmbeddedModel")
	@Getter
	@Setter
	public class EstadosEmbeddedModelOpenApi {
		
		List<EstadoModelOpenApi> estados;
		
	}
}
