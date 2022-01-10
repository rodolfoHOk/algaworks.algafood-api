package com.algaworks.algafood.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.hateoas.TemplateVariable.VariableType;

import com.algaworks.algafood.api.controller.CidadeController;
import com.algaworks.algafood.api.controller.CozinhaController;
import com.algaworks.algafood.api.controller.EstadoController;
import com.algaworks.algafood.api.controller.FluxoPedidoController;
import com.algaworks.algafood.api.controller.FormaPagamentoController;
import com.algaworks.algafood.api.controller.GrupoController;
import com.algaworks.algafood.api.controller.GrupoPermissaoController;
import com.algaworks.algafood.api.controller.PedidoController;
import com.algaworks.algafood.api.controller.PermissaoController;
import com.algaworks.algafood.api.controller.RestauranteController;
import com.algaworks.algafood.api.controller.RestauranteFormasPagamentoController;
import com.algaworks.algafood.api.controller.RestauranteProdutoController;
import com.algaworks.algafood.api.controller.RestauranteProdutoFotoController;
import com.algaworks.algafood.api.controller.RestauranteResponsavelController;
import com.algaworks.algafood.api.controller.UsuarioController;
import com.algaworks.algafood.api.controller.UsuarioGrupoController;

@Component
public class AlgaLinks {
	
	public static final TemplateVariables PAGINACAO_VARIABLES = new TemplateVariables(
			new TemplateVariable("page", VariableType.REQUEST_PARAM),
			new TemplateVariable("size", VariableType.REQUEST_PARAM),
			new TemplateVariable("sort", VariableType.REQUEST_PARAM)
		);
	
	public static final TemplateVariables PROJECAO_VARIABLES = new TemplateVariables(
			new TemplateVariable("projecao", VariableType.REQUEST_PARAM)
		);
	
	public Link linkToCidades() {
		return linkTo(CidadeController.class)
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToCidades(String rel) {
		return linkTo(CidadeController.class)
				.withRel(rel);
	}
	
	public Link linkToEstados() {
		return linkTo(EstadoController.class)
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToEstados(String rel) {
		return linkTo(EstadoController.class)
				.withRel(rel);
	}
	
	public Link linkToCozinhas(String rel) {
		return linkTo(CozinhaController.class)
				.withRel(rel);
	}
	
	public Link linkToFormasPagamento() {
		return linkToFormasPagamento(IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToFormasPagamento(String rel) {
		return linkTo(FormaPagamentoController.class)
				.withRel(rel);
	}
	
	public Link linkToFormasPagamentoRestaurante(Long restauranteId) {
		return linkToFormasPagamentoRestaurante(restauranteId, IanaLinkRelations.SELF_VALUE);
	}
 	
	public Link linkToFormasPagamentoRestaurante(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteFormasPagamentoController.class).listar(restauranteId))
				.withRel(rel);
	}
	
	public Link linkToGrupos() {
		return linkTo(GrupoController.class)
				.withRel(IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToGrupos(String rel) {
		return linkTo(GrupoController.class)
				.withRel(rel);
	}
	
	public Link linkToGruposUsuario(Long usuarioId) {
		return linkToGruposUsuario(usuarioId, IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToGruposUsuario(Long usuarioId, String rel) {
		return linkTo(methodOn(UsuarioGrupoController.class).listar(usuarioId))
				.withRel(rel);
	}
	
	public Link linkToPedidos(String rel) {
		TemplateVariables filterVariables = new TemplateVariables(
				new TemplateVariable("clienteId", VariableType.REQUEST_PARAM),
				new TemplateVariable("restauranteId", VariableType.REQUEST_PARAM),
				new TemplateVariable("dataCriacaoInicio", VariableType.REQUEST_PARAM),
				new TemplateVariable("dataCriacaoFim", VariableType.REQUEST_PARAM)
			);
		
		String pedidosUrl = linkTo(PedidoController.class).toString();
		
		return Link.of(UriTemplate.of(pedidosUrl, PAGINACAO_VARIABLES.concat(filterVariables)), rel);
	}
	
	public Link linkToPermissoes() {
		return linkTo(PermissaoController.class)
				.withRel(IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToPermissoes(String rel) {
		return linkTo(PermissaoController.class)
				.withRel(rel);
	}
	
	public Link linkToPermissoesGrupo(Long grupoId) {
		return linkToPermissoesGrupo(grupoId, IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToPermissoesGrupo(Long grupoId, String rel) {
		return linkTo(methodOn(GrupoPermissaoController.class).listar(grupoId))
				.withRel(rel);
	}
	
	public Link linkToResponsaveisRestaurante(Long restauranteId) {
		return linkTo(methodOn(RestauranteResponsavelController.class).listar(restauranteId))
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToResponsaveisRestaurante(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteResponsavelController.class).listar(restauranteId))
				.withRel(rel);
	}
	
	public Link linkToRestaurantes() {
		return linkToRestaurantes(IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToRestaurantes(String rel) {
		String restaurantesUrl = linkTo(RestauranteController.class).toString();
		
		return Link.of(UriTemplate.of(restaurantesUrl, PROJECAO_VARIABLES), rel);
	}
	
	public Link linkToRestauranteProdutos(Long restauranteId) {
		return linkToRestauranteProdutos(restauranteId, IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToRestauranteProdutos(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteProdutoController.class).listar(restauranteId, null))
				.withRel(rel);
	}
	
	public Link linkToUsuarios() {
		return linkTo(UsuarioController.class)
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToUsuarios(String rel) {
		return linkTo(UsuarioController.class)
				.withRel(rel);
	}
	
	public Link linkToCidade(Long cidadeId) {
		return linkTo(methodOn(CidadeController.class).buscar(cidadeId))
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToCozinha(Long cozinhaId) {
		return linkTo(methodOn(CozinhaController.class).buscar(cozinhaId))
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToEstado(Long estadoId) {
		return linkTo(methodOn(EstadoController.class).buscar(estadoId))
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToFormaPagamento(Long formaPagamentoId) {
		return linkTo(methodOn(FormaPagamentoController.class).buscar(formaPagamentoId, null))
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linktToGrupoPermissaoAssociar(Long grupoId, String rel) {
		return linkTo(methodOn(GrupoPermissaoController.class).associar(grupoId, null))
				.withRel(rel);
	}
	
	public Link linktToGrupoPermissaoDesassociar(Long grupoId, Long permissaoId, String rel) {
		return linkTo(methodOn(GrupoPermissaoController.class).desassociar(grupoId, permissaoId))
				.withRel(rel);
	}
	
	public Link linkToProduto(Long restauranteId, Long produtoId, String rel) {
		return linkTo(methodOn(RestauranteProdutoController.class).buscar(restauranteId, produtoId))
				.withRel(rel);
	}
	
	public Link linkToRestaurante(Long restauranteId) {
		return linkTo(methodOn(RestauranteController.class).buscar(restauranteId))
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToRestauranteFormaPagamentoAssociacao(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteFormasPagamentoController.class)
				.associar(restauranteId, null))
				.withRel(rel);
	}
	
	public Link linkToRestauranteFormaPagamentoDesassociacao(Long restauranteId, Long formaPagamentoId, String rel) {
		return linkTo(methodOn(RestauranteFormasPagamentoController.class)
				.desassociar(restauranteId, formaPagamentoId))
				.withRel(rel);
	}
	
	public Link linkToRestauranteFotoProduto(Long restauranteId, Long produtoId) 
			throws HttpMediaTypeNotAcceptableException {
		return linkToRestauranteFotoProduto(restauranteId, produtoId, IanaLinkRelations.SELF_VALUE);
	}
	
	public Link linkToRestauranteFotoProduto(Long restauranteId, Long produtoId, String rel) 
			throws HttpMediaTypeNotAcceptableException {
		return linkTo(methodOn(RestauranteProdutoFotoController.class)
				.buscar(restauranteId, produtoId, null))
				.withRel(rel);
	}
	
	public Link linkToRestauranteProduto(Long restauranteId, Long produtoId, String rel) {
		return linkTo(methodOn(RestauranteProdutoController.class)
				.buscar(restauranteId, produtoId))
				.withRel(rel);
	}
	
	public Link linkToRestauranteResponsavelAssociacao(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteResponsavelController.class)
				.associar(restauranteId, null))
				.withRel(rel);
	}
	
	public Link linkToRestauranteResponsavelDesassociacao(Long restauranteId, Long usuarioId, String rel) {
		return linkTo(methodOn(RestauranteResponsavelController.class)
				.desassociar(restauranteId, usuarioId))
				.withRel(rel);
	}
	
	public Link linkToUsuario(Long usuarioId) {
		return linkTo(methodOn(UsuarioController.class).buscar(usuarioId))
				.withRel(IanaLinkRelations.SELF);
	}
	
	public Link linkToUsuarioGrupoAssociar(Long usuarioId, String rel) {
		return linkTo(methodOn(UsuarioGrupoController.class).associar(usuarioId, null))
				.withRel(rel);
	}
	
	public Link linkToUsuarioGrupoDesassociar(Long usuarioId, Long grupoId, String rel) {
		return linkTo(methodOn(UsuarioGrupoController.class).desassociar(usuarioId, grupoId))
				.withRel(rel);
	}
	
	public Link linkToConfirmacaoPedido(String codigoPedido, String rel) {
		return linkTo(methodOn(FluxoPedidoController.class).confirmar(codigoPedido))
				.withRel(rel);
	}
	
	public Link linkToCancelamentoPedido(String codigoPedido, String rel) {
		return linkTo(methodOn(FluxoPedidoController.class).cancelar(codigoPedido))
				.withRel(rel);
	}
	
	public Link linkToEntregaPedido(String codigoPedido, String rel) {
		return linkTo(methodOn(FluxoPedidoController.class).entregue(codigoPedido))
				.withRel(rel);
	}
	
	public Link linkToAtivarRestaurante(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteController.class).ativar(restauranteId))
				.withRel(rel);
	}
	
	public Link linkToInativarRestaurante(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteController.class).inativar(restauranteId))
				.withRel(rel);
	}
	
	public Link linkToAbrirRestaurante(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteController.class).abrir(restauranteId))
				.withRel(rel);
	}
	
	public Link linkToFecharRestaurante(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteController.class).fechar(restauranteId))
				.withRel(rel);
	}
	
}
