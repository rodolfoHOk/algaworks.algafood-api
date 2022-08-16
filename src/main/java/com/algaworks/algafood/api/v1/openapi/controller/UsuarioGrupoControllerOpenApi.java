package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.GrupoModel;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "security_auth")
public interface UsuarioGrupoControllerOpenApi {

	CollectionModel<GrupoModel> listar(Long usuarioId);

	ResponseEntity<Void> associar(Long usuarioId, Long grupoId);

	ResponseEntity<Void> desassociar(Long usuarioId, Long grupoId);

}