package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInputV2 {

	@NotBlank
	private String nomeCidade;
	
	@NotNull
	private Long idEstado;
	
}
