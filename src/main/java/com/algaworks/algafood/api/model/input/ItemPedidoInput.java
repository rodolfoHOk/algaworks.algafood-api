package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoInput {

	@ApiModelProperty(example = "1", required = true)
	@NotNull
	private Long produtoId;
	
	@ApiModelProperty(example = "3", required = true)
	@NotNull
	@Positive
	private Integer quantidade;
	
	@ApiModelProperty(example = "Sem pimenta")
	private String observacao;
	
}
