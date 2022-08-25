package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.controller.EstatisticasController.EstatisticasModel;
import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.model.dto.VendaDiaria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Estatísticas")
@SecurityRequirement(name = "security_auth")
public interface EstatisticasControllerOpenApi {
	
	@Operation(hidden = true)
	EstatisticasModel estatisticas();

	@Operation(summary = "Consulta estatísticas de vendas diárias",
			parameters = {
				@Parameter(name = "restauranteId", in = ParameterIn.QUERY, description = "Filtrar pelo ID de um restaurante",
					schema = @Schema(type = "integer", example = "1")),
				@Parameter(in = ParameterIn.QUERY, name="dataCriacaoInicio", description = "Filtrar pela data/hora de criação inicial (de)",
					schema = @Schema(type = "string", format = "date-time", example = "2022-08-23T15:44:37.343Z")),
				@Parameter(in = ParameterIn.QUERY, name="dataCriacaoFim", description = "Filtrar pela data/hora de criação final (até)",
					schema = @Schema(type = "string", format = "date-time", example = "2022-08-24T15:44:37.343Z"))
			},
			responses = {
				@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VendaDiaria.class))),
					@Content(mediaType = "application/pdf", schema = @Schema(type = "string", format = "binary"))
				})
			}
	)
	List<VendaDiaria> consultarVendasDiarias(
			@Parameter(hidden = true) VendaDiariaFilter filtro, 
			@Parameter(description = "Horário em relação ao UTC") String timeOffset);

	@Operation(hidden = true)
	ResponseEntity<byte[]> consultarVendasDiariasPdf(VendaDiariaFilter filtro, String timeOffset);

}