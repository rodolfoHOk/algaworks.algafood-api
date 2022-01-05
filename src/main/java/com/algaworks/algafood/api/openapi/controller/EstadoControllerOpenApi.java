package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.EstadoModel;
import com.algaworks.algafood.api.model.input.EstadoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Estados")
public interface EstadoControllerOpenApi {

	@ApiOperation(value = "Lista os estados")
	List<EstadoModel> listar();

	@ApiOperation(value = "Busca um estado por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID de estado inválido",
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Estado não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	EstadoModel buscar(
			@ApiParam(value = "ID de um estado", required = true, example = "1") Long estadoId);

	@ApiOperation(value = "Cadastra um estado")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Estado cadastrado")
	})
	EstadoModel adicionar(
			@ApiParam(value = "Representação de um novo estado", required = true, name = "corpo")
			EstadoInput estadoInput);

	@ApiOperation(value = "Atualiza um estado por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Estado atualizado"),
		@ApiResponse(responseCode = "404", description = "Estado não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	EstadoModel atualizar(
			@ApiParam(value = "ID de um estado", required = true, example = "1") Long estadoId,
			@ApiParam(value = "Representação de um estado com novos dados", required = true, name = "corpo")
			EstadoInput estadoInput);

	@ApiOperation(value = "Exclui um estado por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Estado excluído"),
		@ApiResponse(responseCode = "404", description = "Estado não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	void remover(
			@ApiParam(value = "ID de um estado", required = true, example = "1") Long estadoId);

}