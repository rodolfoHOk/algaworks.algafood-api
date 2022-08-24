package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.api.v1.model.PedidoResumoModel;
import com.algaworks.algafood.api.v1.model.input.PedidoInput;
import com.algaworks.algafood.core.springdoc.PageableParameter;
import com.algaworks.algafood.domain.filter.PedidoFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedidos")
@SecurityRequirement(name = "security_auth")
public interface PedidoControllerOpenApi {

	@PageableParameter
	@Operation(summary = "Pesquisa pedidos", parameters = {
			@Parameter(in = ParameterIn.QUERY, name="clienteId", description = "Filtrar pelo ID do cliente",
				schema = @Schema(type = "integer", example = "1")),
			@Parameter(in = ParameterIn.QUERY, name="restauranteId", description = "Filtrar pelo ID do restaurante",
				schema = @Schema(type = "integer", example = "1")),
			@Parameter(in = ParameterIn.QUERY, name="dataCriacaoInicio", description = "Filtrar pela data/hora de criação inicial (de)",
				schema = @Schema(type = "string", format = "date-time", example = "2022-08-23T15:44:37.343Z")),
			@Parameter(in = ParameterIn.QUERY, name="dataCriacaoFim", description = "Filtrar pela data/hora de criação final (até)",
				schema = @Schema(type = "string", format = "date-time", example = "2022-08-24T15:44:37.343Z"))
	})
	PagedModel<PedidoResumoModel> pesquisar(
			@Parameter(hidden = true) PedidoFilter filtro,
			@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Busca um pedido pelo código", responses = {
			@ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "400", description = "Código do pedido inválido",
					content = @Content(schema = @Schema(ref = "Problema"))),
			@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
			content = @Content(schema = @Schema(ref = "Problema")))
	})
	PedidoModel buscar(
			@Parameter(description = "Código de um pedido", example = "390e74c6-23c5-11ed-861d-0242ac120002", required = true) String codigoPedido);

	@Operation(summary = "Registra um pedido", responses = {
			@ApiResponse(responseCode = "201", description = "Pedido registrado"),
	})
	PedidoModel emitir(
			@RequestBody(description = "Representação de um novo pedido", required = true) PedidoInput pedidoInput);

}