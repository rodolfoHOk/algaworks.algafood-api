package com.algaworks.algafood.api.v1.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.api.v1.model.FotoProdutoModel;
import com.algaworks.algafood.api.v1.model.input.FotoProdutoInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "security_auth")
public interface RestauranteProdutoFotoControllerOpenApi {

	@Operation(summary = "Busca a foto do produto de um restaurante", responses = {
		@ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = FotoProdutoModel.class)),
			@Content(mediaType = "image/jpeg", schema = @Schema(type = "string", format = "binary")),
			@Content(mediaType = "image/png", schema = @Schema(type = "string", format = "binary"))
		})
	})
	ResponseEntity<?> buscar(Long restauranteId, Long produtoId, String acceptHeader) throws HttpMediaTypeNotAcceptableException;

	FotoProdutoModel atualizarFoto(Long restauranteId, Long produtoId, FotoProdutoInput fotoProdutoInput, MultipartFile arquivo) throws IOException;

	void excluir(Long restauranteId, Long produtoId);

}