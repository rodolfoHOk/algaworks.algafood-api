package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.v1.model.CozinhaModel;
import com.algaworks.algafood.api.v1.model.input.CozinhaInput;

public interface CozinhaControllerOpenApi {

	PagedModel<CozinhaModel> listar(Pageable pageable);

	CozinhaModel buscar(Long cozinhaId);

	CozinhaModel adicionar(CozinhaInput cozinhaInput);

	CozinhaModel atualizar(Long cozinhaId, CozinhaInput cozinhaInput);

	void remover(Long cozinhaId);

}