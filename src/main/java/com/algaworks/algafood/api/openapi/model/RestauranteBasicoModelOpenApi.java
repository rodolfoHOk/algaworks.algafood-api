package com.algaworks.algafood.api.openapi.model;

import java.math.BigDecimal;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.CozinhaModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("RestauranteBasicoModel")
@Getter
@Setter
public class RestauranteBasicoModelOpenApi {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Thai Gourmet")
	private String nome;
	
	@ApiModelProperty(example = "11.55")
	private BigDecimal taxaFrete;
	
	private CozinhaModel cozinha;
	
	private Links _links;
	
}
