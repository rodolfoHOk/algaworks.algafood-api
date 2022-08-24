package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.v1.model.RestauranteBasicoModel;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.api.v1.model.input.RestauranteInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Restaurantes")
@SecurityRequirement(name = "security_auth")
public interface RestauranteControllerOpenApi {

	@Operation(summary = "Lista os restaurantes", parameters = {
		@Parameter(name = "projecao", description = "Nome da projeção", example = "apenas-nome", in = ParameterIn.QUERY)
	})
	CollectionModel<RestauranteBasicoModel> listar();

	@Operation(hidden = true)
	CollectionModel<RestauranteApenasNomeModel> listarApenasNomes();

	@Operation(summary = "Buscar um restaturante por ID", responses = {
		@ApiResponse(responseCode = "200"),
		@ApiResponse(responseCode = "400", description = "ID do restaurante inválido",
			content = @Content(schema = @Schema(ref = "Problema"))),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
			content = @Content(schema = @Schema(ref = "Problema"))),
	})
	RestauranteModel buscar(
		@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Cadastra um novo restaturante", responses = {
		@ApiResponse(responseCode = "201", description = "Restaurante cadastrado"),
	})
	RestauranteModel adicionar(
		@RequestBody(description = "Representação de um novo restaurante", required = true) RestauranteInput restauranteInput);

	@Operation(summary = "Buscar um restaturante por ID", responses = {
		@ApiResponse(responseCode = "200"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
			content = @Content(schema = @Schema(ref = "Problema"))),
	})
	RestauranteModel atualizar(
		@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
		@RequestBody(description = "Representação de um restaurante com dados atualizados", required = true) RestauranteInput restauranteInput);

	@Operation(summary = "Buscar um restaturante por ID", responses = {
		@ApiResponse(responseCode = "204", description = "Sem conteúdo"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
			content = @Content(schema = @Schema(ref = "Problema"))),
	})
	void remover(
		@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Ativa um restaturante por ID", responses = {
		@ApiResponse(responseCode = "204", description = "Restaurante ativado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
			content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ResponseEntity<Void> ativar(
		@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Desativa um restaturante por ID", responses = {
		@ApiResponse(responseCode = "204", description = "Restaurante inativado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
			content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ResponseEntity<Void> inativar(
		@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Ativa multiplos restaturantes por IDs", responses = {
			@ApiResponse(responseCode = "204", description = "Restaurantes ativados com sucesso")
	})
	void ativarMultiplos(
		@RequestBody(description = "Lista de IDs de restaurantes", required = true) List<Long> restaurantesIds);

	@Operation(summary = "Desativa multiplos restaturantes por ID", responses = {
			@ApiResponse(responseCode = "204", description = "Restaurantes inativados com sucesso")
	})
	void inativarMultiplos(
		@RequestBody(description = "Lista de IDs de restaurantes", required = true) List<Long> restaurantesIds);

	@Operation(summary = "Fecha um restaturante por ID", responses = {
		@ApiResponse(responseCode = "204", description = "Restaurante fechado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
			content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ResponseEntity<Void> fechar(
		@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Abre um restaturante por ID", responses = {
		@ApiResponse(responseCode = "204", description = "restaurante aberto com sucesso"),
		@ApiResponse(responseCode = "404", description = "Restaurante não encontrado",
			content = @Content(schema = @Schema(ref = "Problema"))),
	})
	ResponseEntity<Void> abrir(
		@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

}