package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteModel extends RepresentationModel<RestauranteModel>{
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Thai Gourmet")
	private String nome;
	
	@ApiModelProperty(example = "11.55")
	private BigDecimal taxaFrete;
	
	private CozinhaModel cozinha;
	
	private Boolean ativo;
	private Boolean aberto;
	private EnderecoModel endereco;
	
}
