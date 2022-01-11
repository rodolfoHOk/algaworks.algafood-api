package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("RestaurantesModel")
@Getter
@Setter
public class RestaurantesModelOpenApi {
	
	private RestaurantesEmbeddedModelOpenApi _embedded;
	private Links _links;

	@ApiModel("RestaurantesEmbeddedModel")
	@Getter
	@Setter
	public class RestaurantesEmbeddedModelOpenApi {
		
		List<RestauranteBasicoModelOpenApi> restaurantes;
		
	}
}
