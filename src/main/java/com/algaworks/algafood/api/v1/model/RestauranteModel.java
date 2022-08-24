package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteModel extends RepresentationModel<RestauranteModel>{
	
	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "Thai Gourmet")
	private String nome;
	
	@Schema(example = "5.50")
	private BigDecimal taxaFrete;
	
	private CozinhaModel cozinha;
	
	private Boolean ativo;
	
	private Boolean aberto;
	
	private EnderecoModel endereco;
	
}
