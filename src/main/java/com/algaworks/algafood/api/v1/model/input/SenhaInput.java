package com.algaworks.algafood.api.v1.model.input;

import jakarta.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenhaInput {
	
	@NotBlank
	@Schema(example = "abc123")
	private String senhaAtual;
	
	@NotBlank
	@Schema(example = "cba321")
	private String novaSenha;
	
}
