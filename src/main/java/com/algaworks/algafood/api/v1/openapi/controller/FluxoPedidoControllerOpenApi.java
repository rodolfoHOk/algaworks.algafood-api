package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedidos")
@SecurityRequirement(name = "security_auth")
public interface FluxoPedidoControllerOpenApi {

	@Operation(summary = "Confirmação de pedido", responses = {
			@ApiResponse(responseCode = "204", description = "Pedido confirmado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
				content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ResponseEntity<Void> confirmar(
			@Parameter(description = "Código de um pedido", example = "390e74c6-23c5-11ed-861d-0242ac120002", required = true) String codigoPedido);

	@Operation(summary = "Cancelamento de pedido", responses = {
			@ApiResponse(responseCode = "204", description = "Pedido cancelado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
				content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ResponseEntity<Void> cancelar(
			@Parameter(description = "Código de um pedido", example = "390e74c6-23c5-11ed-861d-0242ac120002", required = true) String codigoPedido);

	@Operation(summary = "Registra entrega de pedido", responses = {
			@ApiResponse(responseCode = "204", description = "Entrega de pedido registrada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Pedido não encontrado",
				content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ResponseEntity<Void> entregue(
			@Parameter(description = "Código de um pedido", example = "390e74c6-23c5-11ed-861d-0242ac120002", required = true) String codigoPedido);

}