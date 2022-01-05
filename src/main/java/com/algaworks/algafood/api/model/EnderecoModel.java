package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {

	@ApiModelProperty(example = "38403-180")
	private String cep;
	
	@ApiModelProperty(example = "Rua Floriano Peixoto")
	private String logradouro;
	
	@ApiModelProperty(example = "346")
	private String numero;
	
	@ApiModelProperty(example = "Apto 801")
	private String complemento;
	
	@ApiModelProperty(example = "Jd Brasil")
	private String bairro;
	
	private CidadeResumoModel cidade;
	
}
