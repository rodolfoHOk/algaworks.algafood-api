package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenhaInput {
	
	@ApiModelProperty(example = "abc123", required = true)
	@NotBlank
	private String senhaAtual;
	
	@ApiModelProperty(example = "abc123", required = true)
	@NotBlank
	private String novaSenha;
	
}
