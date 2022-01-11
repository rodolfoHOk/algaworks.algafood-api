package com.algaworks.algafood.api.v1.openapi.model;

import com.algaworks.algafood.api.v1.model.CidadeResumoModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("EnderecoModel")
@Getter
@Setter
public class EnderecoModelOpenApi {

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
