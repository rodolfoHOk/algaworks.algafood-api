package com.algaworks.algafood.api.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;
import com.algaworks.algafood.api.openapi.model.FormaPagamentoModelOpenApi;
import com.algaworks.algafood.api.openapi.model.FormasPagamentoModelOpenApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Formas de Pagamento")
public interface FormaPagamentoControllerOpenApi {

	@ApiOperation(value = "Lista as formas de pagamento")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", 
				content = @Content(schema = @Schema(implementation = FormasPagamentoModelOpenApi.class),
				mediaType = "application/json"))
	})
	ResponseEntity<CollectionModel<FormaPagamentoModel>> listar(ServletWebRequest request);

	@ApiOperation(value = "Busca uma forma de pagamento por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK",
				content = @Content(schema = @Schema(implementation = FormaPagamentoModelOpenApi.class),
				mediaType = "application/json")),
		@ApiResponse(responseCode = "400", description = "ID de forma de pagamento inválido",
				content = @Content(schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	ResponseEntity<FormaPagamentoModel> buscar(
			@ApiParam(value = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId,
			ServletWebRequest request);

	@ApiOperation("Cadastra uma forma de pagamento")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Forma de pagamento cadastrada")
	})
	FormaPagamentoModel adicionar(
			@ApiParam(value = "Representação de uma nova forma de pagamento", name = "corpo", required = true) 
			FormaPagamentoInput formaPagamentoInput);

	@ApiOperation("Atualiza uma forma de pagamento por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Forma de pagamento atualizada"),
		@ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	FormaPagamentoModel atualizar(
			@ApiParam(value = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId,
			@ApiParam(value = "Representação de uma forma de pagamento com novos dados", name = "corpo", required = true) 
			FormaPagamentoInput formaPagamentoInput);

	@ApiOperation("Exclui uma forma de pagamento por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Forma de pagamento excluída"),
		@ApiResponse(responseCode = "404", description = "Forma de pagamento não encontrada",
				content = @Content(schema = @Schema(implementation = Problem.class)))
	})
	void remover(
			@ApiParam(value = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId);

}