package com.algaworks.algafood.api.v1.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

	@NotBlank
	@Schema(example = "12345-123")
	private String cep;
	
	@NotBlank
	@Schema(example = "Rua da gaivotas")
	private String logradouro;
	
	@NotBlank
	@Schema(example = "123")
	private String numero;
	
	@Schema(example = "Apto 123")
	private String complemento;
	
	@NotBlank
	@Schema(example = "Moema")
	private String bairro;
	
	@Valid
	@NotNull
	private CidadeIdInput cidade;
	
}
