package com.algaworks.algafood.domain.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class VendaDiaria {
	
	@Schema(example = "2022-08-23T15:44:37.343Z")
	private Date data;
	
	@Schema(example = "123")
	private Long totalVendas;
	
	@Schema(example = "12345.67")
	private BigDecimal totalFaturado;
	
}
