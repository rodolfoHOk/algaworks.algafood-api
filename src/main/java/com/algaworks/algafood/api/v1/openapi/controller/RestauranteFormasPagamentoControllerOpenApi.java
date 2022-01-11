package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteFormasPagamentoControllerOpenApi {

	@ApiOperation("Lista formas de pagamentos associadas ao restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	CollectionModel<FormaPagamentoModel> listar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId);

	@ApiOperation("Desassociação de forma de pagamento ao restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Desassociação realizada com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante ou forma de pagamento não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	ResponseEntity<Void> desassociar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId,
			@ApiParam(value = "ID da forma de pagamento", example = "1", required = true) Long formaPagamentoId);

	@ApiOperation("Associação de forma de pagamento ao restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Associação realizada com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante ou forma de pagamento não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	ResponseEntity<Void> associar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId,
			@ApiParam(value = "ID da forma de pagamento", example = "1", required = true) Long formaPagamentoId);

}