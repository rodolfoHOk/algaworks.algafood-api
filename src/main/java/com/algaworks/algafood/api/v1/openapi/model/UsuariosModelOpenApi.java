package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("UsuariosModel")
@Getter
@Setter
public class UsuariosModelOpenApi {
	
	private UsuariosEmbeddedModelOpenApi _embedded;
	private Links _links;

	@ApiModel("UsuariosEmbeddedModel")
	@Getter
	@Setter
	public class UsuariosEmbeddedModelOpenApi {
		
		List<UsuarioModelOpenApi> usuarios;
		
	}
}
