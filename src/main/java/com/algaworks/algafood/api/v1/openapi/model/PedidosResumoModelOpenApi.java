package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("PedidosResumoModel")
@Getter
@Setter
public class PedidosResumoModelOpenApi {
	
	private PedidosResumoEmbeddedModelOpenApi _embedded;
	private Links _links;
	private PageModelOpenApi page;
	
	@ApiModel("PedidosResumoEmbeddedModel")
	@Getter
	@Setter
	public class PedidosResumoEmbeddedModelOpenApi {
		
		List<PedidoResumoModelOpenApi> pedidos;
	}

}
