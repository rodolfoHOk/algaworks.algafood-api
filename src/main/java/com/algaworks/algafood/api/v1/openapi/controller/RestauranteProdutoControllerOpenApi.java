package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.ProdutoModel;
import com.algaworks.algafood.api.v1.model.input.ProdutoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Produtos")
public interface RestauranteProdutoControllerOpenApi {

	@ApiOperation("Lista os produtos de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do restaurante inválido",
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	CollectionModel<ProdutoModel> listar(
			@ApiParam(value = "Id do restaurante", example = "1", required = true) Long restauranteId,
			@ApiParam(value = "Indica de deve ou não incluir produtos inativos no resultado",
					example = "false", defaultValue = "false") Boolean incluirInativos);

	@ApiOperation("Busca um produto de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do restaurante ou do produto inválido",
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Produto de restaurante não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	ProdutoModel buscar(
			@ApiParam(value = "Id do restaurante", example = "1", required = true) Long restauranteId,
			@ApiParam(value = "Id do produto", example = "1", required = true) Long produtoId);

	@ApiOperation("Cadastra um produto de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Produto cadastrado"),
		@ApiResponse(responseCode = "404", description = "Produto de restaurante ou restaurante não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	ProdutoModel adicionar(
			@ApiParam(value = "Id do restaurante", example = "1", required = true) Long restauranteId,
			@ApiParam(value = "Represantação do novo produto", name = "corpo", required = true)
			ProdutoInput produtoInput);

	@ApiOperation("Atualiza um produto de um restaurante")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Produto atualizado"),
		@ApiResponse(responseCode = "404", description = "Produto de restaurante não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	ProdutoModel atualizar(
			@ApiParam(value = "Id do restaurante", example = "1", required = true) Long restauranteId,
			@ApiParam(value = "Id do produto", example = "1", required = true) Long produtoId, 
			@ApiParam(value = "Represantação do produto com novos dados", name = "corpo", required = true) 
			ProdutoInput produtoInput);

}