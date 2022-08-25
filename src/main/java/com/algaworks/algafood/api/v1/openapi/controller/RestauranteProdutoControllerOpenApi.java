package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.ProdutoModel;
import com.algaworks.algafood.api.v1.model.input.ProdutoInput;

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
public interface RestauranteProdutoControllerOpenApi {

	@Operation(summary = "Lista os produtos de um restaurante", responses = {
			@ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "400", description = "ID do Restaurante inválido",
				content = @Content(schema = @Schema(ref = "Problema"))),
			@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
				content = @Content(schema = @Schema(ref = "Problema"))),
	})
	CollectionModel<ProdutoModel> listar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "Incluir inativos", example = "false", required = false) Boolean incluirInativos);

	@Operation(summary = "Buscar um produto de um restaurante", responses = {
			@ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "400", description = "ID do Restaurante ou produto inválido",
				content = @Content(schema = @Schema(ref = "Problema"))),
			@ApiResponse(responseCode = "404", description = "Restaurante ou produto não encontrado",
				content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ProdutoModel buscar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de um produto", example = "2", required = true) Long produtoId);

	@Operation(summary = "Cadastra um produto de um restaurante", responses = {
			@ApiResponse(responseCode = "201", description = "Produto cadastrado"),
			@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
				content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ProdutoModel adicionar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@RequestBody(description = "Representação de um novo produto", required = true) ProdutoInput produtoInput);

	@Operation(summary = "Atualiza um produto de um restaurante", responses = {
			@ApiResponse(responseCode = "200", description = "Produto atualizado"),
			@ApiResponse(responseCode = "404", description = "Restaurante ou produto não encontrado",
				content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ProdutoModel atualizar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de um produto", example = "2", required = true) Long produtoId, 
			@RequestBody(description = "Representação de um produto com dados atualizados", required = true) ProdutoInput produtoInput);

}