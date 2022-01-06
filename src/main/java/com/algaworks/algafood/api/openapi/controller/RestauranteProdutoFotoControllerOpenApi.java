package com.algaworks.algafood.api.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.FotoProdutoModel;
import com.algaworks.algafood.api.model.input.FotoProdutoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Produtos")
public interface RestauranteProdutoFotoControllerOpenApi {

	@ApiOperation(value = "Busca foto do produto de um restaurante", 
			produces = "application/json, image/jpeg, image/png")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", 
				content = @Content(schema = @Schema(implementation = FotoProdutoModel.class), mediaType = "application/json")),
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "image/png")),
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "image/jpeg")),
		@ApiResponse(responseCode = "400", description = "ID do restaurante ou produto inválido", 
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Foto do produto não encontrada", 
			content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	ResponseEntity<?> buscar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId,
			@ApiParam(value = "ID do produto", example = "1", required = true) Long produtoId, 
			@ApiParam(hidden = true, required = false) String acceptHeader)
			throws HttpMediaTypeNotAcceptableException;

	@ApiOperation(value = "Atualiza a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Foto do produto atualizada"),
		@ApiResponse(responseCode = "404", description = "Produto de restaurante não encontrado", 
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	FotoProdutoModel atualizarFoto(
			@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId, 
			@ApiParam(value = "ID do produto", example = "1", required = true) Long produtoId, 
			FotoProdutoInput fotoProdutoInput, 
			@ApiParam(value = "Arquivo da foto do produto (máximo 500KB, apenas JPG e PNG)", required = true)
			MultipartFile arquivo)
			throws IOException;

	@ApiOperation(value = "Exclui a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Foto do produto excluída"),
		@ApiResponse(responseCode = "400", description = "ID do restaurante ou produto inválido", 
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Produto de restaurante não encontrado", 
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	void excluir(
			@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId, 
			@ApiParam(value = "ID do produto", example = "1", required = true) Long produtoId);

}