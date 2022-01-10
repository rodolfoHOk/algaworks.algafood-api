package com.algaworks.algafood.api.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.model.input.GrupoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoControllerOpenApi {

	@ApiOperation("Lista os grupos")
	CollectionModel<GrupoModel> listar();

	@ApiOperation("Busca um grupo por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "ID do grupo inválido", 
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Grupo não encontrado", 
				content = @Content(schema = @Schema(implementation = Problem.class)))	
	})
	GrupoModel buscar(@ApiParam(value = "ID de um grupo", example = "1") Long grupoId);

	@ApiOperation("Cadastra um grupo")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Grupo cadastrado")
	})
	GrupoModel adicionar(@ApiParam(value = "Representação de um novo grupo", name = "corpo") GrupoInput grupoInput);

	@ApiOperation("Atualiza um grupo por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Grupo atualizado"),
		@ApiResponse(responseCode = "404", description = "Grupo não encontrado", 
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	GrupoModel atualizar(@ApiParam(value = "ID de um grupo", example = "1") Long grupoId, 
			@ApiParam(value = "Representação de um novo grupo", name = "corpo") GrupoInput grupoInput);

	@ApiOperation("Exclui um grupo por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Grupo excluído"),
		@ApiResponse(responseCode = "404", description = "Grupo não encontrado",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	void remover(@ApiParam(value = "ID de um grupo", example = "1") Long grupoId);

}