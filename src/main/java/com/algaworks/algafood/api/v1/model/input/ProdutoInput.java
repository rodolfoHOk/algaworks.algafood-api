package com.algaworks.algafood.api.v1.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {
	
	@NotBlank
	@Schema(example = "Porco com molho agridoce")
	private String nome;
	
	@NotBlank
	@Schema(example = "Lombo de porco assado com molho agridoce levemente apimentado")
	private String descricao;
	
	@NotNull
	@PositiveOrZero
	@Schema(example = "49.50")
	private BigDecimal preco;
	
	@NotNull
	@Schema(example = "true")
	private Boolean ativo;
	
}
