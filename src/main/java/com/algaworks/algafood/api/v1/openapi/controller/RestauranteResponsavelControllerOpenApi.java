package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.UsuarioModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Restaurantes")
@SecurityRequirement(name = "security_auth")
public interface RestauranteResponsavelControllerOpenApi {

	@Operation(summary = "Lista os usuários responsáveis associados a um restaurante", responses = {
			@ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
				content = @Content(schema = @Schema(ref = "Problema")))
	})
	CollectionModel<UsuarioModel> listar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Associa um usuário responsável a um restaurante", responses = {
			@ApiResponse(responseCode = "204", description = "Associação realizada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Restaurante ou usuário não encontrado",
				content = @Content(schema = @Schema(ref = "Problema")))
	})
	ResponseEntity<Void> associar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID do usuário responsável pelo restaurante", example = "1", required = true) Long usuarioId);

	@Operation(summary = "Desassocia um usuário responsável a um restaurante", responses = {
			@ApiResponse(responseCode = "204", description = "Desassociação realizada com sucesso"),
			@ApiResponse(responseCode = "404", description = "Restaurante ou usuário não encontrado",
				content = @Content(schema = @Schema(ref = "Problema")))
	})
	ResponseEntity<Void> desassociar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID do usuário responsável pelo restaurante", example = "1", required = true) Long usuarioId);

}