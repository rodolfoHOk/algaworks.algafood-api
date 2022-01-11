package com.algaworks.algafood.api.openapi.model;

import org.springframework.hateoas.Links;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("FotoProdutoModel")
@Getter
@Setter
public class FotoProdutoModelOpenApi {

	@ApiModelProperty(example = "d9d82bdc-f488-43e5-ac02-f8fb23461f4c_primerib.jpg")
	private String nomeArquivo;
	
	@ApiModelProperty(example = "Prime Rib ao ponto")
	private String descricao;
	
	@ApiModelProperty(example = "image/jpeg")
	private String contentType;
	
	@ApiModelProperty(example = "72658")
	private Long tamanho;
	
	private Links _links;
	
}
