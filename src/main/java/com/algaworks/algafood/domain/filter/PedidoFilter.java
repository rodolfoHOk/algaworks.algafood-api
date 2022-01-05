package com.algaworks.algafood.domain.filter;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoFilter {
	
	@ApiModelProperty(example = "1", value = "ID do cliente para filtro da pesquisa")
	private Long clienteId;
	
	@ApiModelProperty(example = "1", value = "ID do restaurante para filtro da pesquisa")
	private Long restauranteId;
	
	@ApiModelProperty(example = "2022-01-04T17:07:59Z",
	        value = "Data/hora de criação inicial para filtro da pesquisa")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dataCriacaoInicio;
	
	@ApiModelProperty(example = "2022-01-05T17:07:59Z",
	        value = "Data/hora de criação final para filtro da pesquisa")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dataCriacaoFim;

}
