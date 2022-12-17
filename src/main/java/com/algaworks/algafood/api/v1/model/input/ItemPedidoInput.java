package com.algaworks.algafood.api.v1.model.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoInput {

	@NotNull
	@Schema(example = "1")
	private Long produtoId;
	
	@NotNull
	@Positive
	@Schema(example = "2")
	private Integer quantidade;
	
	@Schema(example = "Sem pimenta")
	private String observacao;
	
}
