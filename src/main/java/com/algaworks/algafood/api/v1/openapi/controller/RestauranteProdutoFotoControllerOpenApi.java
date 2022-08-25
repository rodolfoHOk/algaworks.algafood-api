package com.algaworks.algafood.api.v1.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import com.algaworks.algafood.api.v1.model.FotoProdutoModel;
import com.algaworks.algafood.api.v1.model.input.FotoProdutoInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produtos")
@SecurityRequirement(name = "security_auth")
public interface RestauranteProdutoFotoControllerOpenApi {

	@Operation(summary = "Busca a foto do produto de um restaurante", responses = {
		@ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = FotoProdutoModel.class)),
			@Content(mediaType = "image/jpeg", schema = @Schema(type = "string", format = "binary")),
			@Content(mediaType = "image/png", schema = @Schema(type = "string", format = "binary"))
		}),
		@ApiResponse(responseCode = "400", description = "ID de restaurante ou produto inválido",
			content = @Content(schema = @Schema(ref = "Problema"))),
		@ApiResponse(responseCode = "404", description = "Foto do produto não encontrada",
				content = @Content(schema = @Schema(ref = "Problema")))
	})
	ResponseEntity<?> buscar(
			@Parameter(description = "Id de um restaurente", example = "1", required = true) Long restauranteId,
			@Parameter(description = "Id de um produto", example = "1", required = true) Long produtoId,
			@Parameter(description = "Media type requerido", example = "image/png") String acceptHeader) throws HttpMediaTypeNotAcceptableException;

	@Operation(summary = "Atualiza a foto do produto de um restaurante", responses = {
			@ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "404", description = "Foto do produto não encontrada",
					content = @Content(schema = @Schema(ref = "Problema")))
	})
	FotoProdutoModel atualizarFoto(
			@Parameter(description = "Id de um restaurante", example = "1", required = true) Long restauranteId, 
			@Parameter(description = "Id de um produto", example = "2", required = true) Long produtoId,
			@RequestBody(required = true) FotoProdutoInput fotoProdutoInput
	) throws IOException;

	@Operation(summary = "Exclui a foto do produto de um restaurante", responses = {
			@ApiResponse(responseCode = "204", description = "Foto excluída com sucesso"),
			@ApiResponse(responseCode = "404", description = "Foto do produto não encontrada",
					content = @Content(schema = @Schema(ref = "Problema")))
	})
	void excluir(
			@Parameter(description = "Id de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "Id de um produto", example = "2", required = true) Long produtoId);

}