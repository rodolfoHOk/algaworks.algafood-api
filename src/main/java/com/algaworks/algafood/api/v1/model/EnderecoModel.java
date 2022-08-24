package com.algaworks.algafood.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {

	@Schema(example = "12345-123")
	private String cep;
	
	@Schema(example = "Rua da gaivotas")
	private String logradouro;
	
	@Schema(example = "123")
	private String numero;
	
	@Schema(example = "Apto 123")
	private String complemento;
	
	@Schema(example = "Moema")
	private String bairro;
	
	private CidadeResumoModel cidade;
	
}
