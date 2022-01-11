package com.algaworks.algafood.api.openapi.model;

import java.math.BigDecimal;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("ProdutoModel")
@Getter
@Setter
public class ProdutoModelOpenApi {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Camarão tailandês")
	private String nome;
	
	@ApiModelProperty(example = "16 camarões grandes ao molho picante")
	private String descricao;
	
	@ApiModelProperty(example = "110.00")
	private BigDecimal preco;
	
	@ApiModelProperty(example = "true")
	private Boolean ativo;
	
	private Links _links;
	
}
