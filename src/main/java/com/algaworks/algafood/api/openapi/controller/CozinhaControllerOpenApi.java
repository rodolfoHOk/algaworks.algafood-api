package com.algaworks.algafood.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.api.model.input.CozinhaInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Cozinhas")
public interface CozinhaControllerOpenApi {

	@ApiOperation("Lista as cozinhas com paginação")
	Page<CozinhaModel> listar(Pageable pageable);

	@ApiOperation("Busca uma cozinha por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID de cozinha inválido",
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Cozinha não encontrada",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	CozinhaModel buscar(@ApiParam(value = "ID de uma cozinha", example = "1", required = true) Long cozinhaId);

	@ApiOperation("Cadastra uma cozinha")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Cozinha cadastrada"),
	})
	CozinhaModel adicionar(@ApiParam(value = "Representação de uma nova cozinha", name = "corpo", required = true) CozinhaInput cozinhaInput);

	@ApiOperation("Atualiza uma cozinha por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Cozinha atualizada"),
		@ApiResponse(responseCode = "404", description = "Cozinha não encontrada",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	CozinhaModel atualizar(@ApiParam(value = "ID de uma cozinha", example = "1", required = true) Long cozinhaId,
			@ApiParam(value = "Representação de uma cozinha com os novos dados", name = "corpo", required = true) CozinhaInput cozinhaInput);

	@ApiOperation("Exclui uma cozinha por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Cozinha excluída"),
		@ApiResponse(responseCode = "404", description = "Cozinha não encontrada",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	void remover(@ApiParam(value = "ID de uma cozinha", example = "1", required = true) Long cozinhaId);

}