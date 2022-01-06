package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.RestauranteModel;
import com.algaworks.algafood.api.model.input.RestauranteInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteControllerOpenApi {

	@ApiOperation(value = "Lista os restaurantes")
	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nome da projeção de restaurantes", allowableValues = "apenas-nome",
				name = "projecao", paramType = "query", dataTypeClass = String.class)
	})
	List<RestauranteModel> listar();

	@ApiOperation(value = "Lista os restaurantes", hidden = true)
	List<RestauranteModel> listarApenasNomes();

	@ApiOperation(value = "Busca um restaurante por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID de restaurante inválido",
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
		content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	RestauranteModel buscar(
			@ApiParam(value = "ID de um restaurante", required = true, example = "1") Long restauranteId);

	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Restaurante cadastrado")
	})
	@ApiOperation(value = "Cadastra um restaurante")
	RestauranteModel adicionar(
			@ApiParam(value = "Representação de um novo restaurante", required = true, name = "corpo")
			RestauranteInput restauranteInput);

	@ApiOperation(value = "Atualiza um restaurante por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Restaurante atualizado"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
		content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	RestauranteModel atualizar(
			@ApiParam(value = "ID de um restaurante", required = true, example = "1") Long restauranteId,
			@ApiParam(value = "Representação de um restaurante com novos dados", required = true, name = "corpo")
			RestauranteInput restauranteInput);

	@ApiOperation(value = "Exclui um restaurante por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Restaurante excluído"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
		content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	void remover(@ApiParam(value = "ID de um restaurante", required = true, example = "1") Long restauranteId);

	@ApiOperation(value = "Ativa um restaurante por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Restaurante ativado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
		content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	void ativar(@ApiParam(value = "ID de um restaurante", required = true, example = "1") Long restauranteId);

	@ApiOperation(value = "Inativa um restaurante por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Restaurante inativado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
		content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	void inativar(@ApiParam(value = "ID de um restaurante", required = true, example = "1") Long restauranteId);

	@ApiOperation(value = "Ativa múltiplos restaurantes por IDs")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Restaurantes ativados com sucesso")
	})
	void ativarMultiplos(
			@ApiParam(value = "Lista de IDs dos restaurantes", required = true, name = "corpo")
			List<Long> restaurantesIds);

	@ApiOperation(value = "Inativa múltiplos restaurantes por IDs")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Restaurantes inativados com sucesso")
	})
	void inativarMultiplos(
			@ApiParam(value = "Lista de IDs dos restaurantes", required = true, name = "corpo") 
			List<Long> restaurantesIds);

	@ApiOperation(value = "Fecha restaurante por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Restaurante fechado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
		content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	void fechar(@ApiParam(value = "ID de um restaurante", required = true, example = "1") Long restauranteId);

	@ApiOperation(value = "Abre restaurante por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Restaurante aberto com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
		content = @Content(schema = @Schema(implementation = Problem.class))),
	})
	void abrir(@ApiParam(value = "ID de um restaurante", required = true, example = "1") Long restauranteId);

}