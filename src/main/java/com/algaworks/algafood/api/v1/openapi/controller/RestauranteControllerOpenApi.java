package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.v1.model.RestauranteBasicoModel;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.api.v1.model.input.RestauranteInput;

public interface RestauranteControllerOpenApi {

	CollectionModel<RestauranteBasicoModel> listar();

	CollectionModel<RestauranteApenasNomeModel> listarApenasNomes();

	RestauranteModel buscar(Long restauranteId);

	RestauranteModel adicionar(RestauranteInput restauranteInput);

	RestauranteModel atualizar(Long restauranteId, RestauranteInput restauranteInput);

	void remover(Long restauranteId);

	ResponseEntity<Void> ativar(Long restauranteId);

	ResponseEntity<Void> inativar(Long restauranteId);

	void ativarMultiplos(List<Long> restaurantesIds);

	void inativarMultiplos(List<Long> restaurantesIds);

	ResponseEntity<Void> fechar(Long restauranteId);

	ResponseEntity<Void> abrir(Long restauranteId);

}