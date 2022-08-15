package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.model.input.SenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioComSenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioInput;

public interface UsuarioControllerOpenApi {

	CollectionModel<UsuarioModel> listar();

	UsuarioModel buscar(Long usuarioId);

	UsuarioModel adicionar(UsuarioComSenhaInput usuarioComSenhaInput);

	UsuarioModel atualizar(Long usuarioId, UsuarioInput usuarioInput);

	void alterarSenha(Long usuarioId, SenhaInput senhaInput);

}