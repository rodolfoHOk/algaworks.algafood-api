package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.api.v1.model.input.CidadeInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Cidades")
public interface CidadeControllerOpenApi {

	@Operation(summary = "Lista as cidades")
	CollectionModel<CidadeModel> listar();
	
	@Operation(summary = "Busca uma cidade por ID")
	CidadeModel buscar(Long cidadeId);
	
	@Operation(summary = "Cadastra uma cidade", description = "Cadastro de uma cidade, necessita de um estado e um nome válido")
	CidadeModel adicionar(CidadeInput cidadeInput);
	
	@Operation(summary = "Atualiza uma cidade por ID")
	CidadeModel atualizar(Long cidadeId, CidadeInput cidadeInput);
	
	@Operation(summary = "Remove uma cidade por ID")
	void remover(Long cidadeId);
	
}
