package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.UsuarioModel;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "security_auth")
public interface RestauranteResponsavelControllerOpenApi {

	CollectionModel<UsuarioModel> listar(Long restauranteId);

	ResponseEntity<Void> associar(Long restauranteId, Long usuarioId);

	ResponseEntity<Void> desassociar(Long restauranteId, Long usuarioId);

}