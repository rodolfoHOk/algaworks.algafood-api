package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.api.v1.model.input.CidadeInput;

public interface CidadeControllerOpenApi {

	CollectionModel<CidadeModel> listar();
	
	CidadeModel buscar(Long cidadeId);
	
	CidadeModel adicionar(CidadeInput cidadeInput);
	
	CidadeModel atualizar(Long cidadeId, CidadeInput cidadeInput);
	
	void remover(Long cidadeId);
	
}
