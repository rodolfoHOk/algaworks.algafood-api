package com.algaworks.algafood.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.repository.PedidoRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class AlgaSecurity {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
		
	public Long getUsuarioId() {
		Jwt jwt = (Jwt) getAuthentication().getPrincipal();
		
		return jwt.getClaim("usuario_id");
	}
	
	public boolean gerenciaRestaurante(Long restauranteId) {
		if (restauranteId == null) return false;
		
		return restauranteRepository.existsResponsavel(restauranteId, getUsuarioId());
	}
	
	public boolean gerenciaRestauranteDoPedido(String codigoPedido) {
		return pedidoRepository.isResponsavelDoRestauranteDoPedido(codigoPedido, getUsuarioId());
	}
	
	public boolean usuarioAutenticadoIgual(Long usuarioId) {
		return getUsuarioId() != null && usuarioId != null && getUsuarioId().equals(usuarioId);
	}
	
	public boolean podeConsultarCidades() {
		return hasEscopoLeitura() && isAutenticado();
	}
	
	public boolean podeConsultarCozinhas() {
		return hasEscopoLeitura() && isAutenticado();
	}
	
	public boolean podeConsultarEstados() {
		return hasEscopoLeitura() && isAutenticado();
	}
	
	public boolean podeConsultarEstatisticas() {
		return hasEscopoLeitura() && hasAuthority("GERAR_RELATORIOS");
	}
	
	public boolean podeConsultarFormasPagamento() {
		return hasEscopoLeitura() && isAutenticado();
	}
	
	public boolean podeConsultarRestaurantes() {
		return hasEscopoLeitura() && isAutenticado();
	}
	
	public boolean podeConsultarUsuariosGruposPermissoes() {
		return hasEscopoLeitura() && hasAuthority("CONSULTAR_USUARIOS_GRUPOS_PERMISSOES");
	}
	
	public boolean podeEditarUsuariosGruposPermissoes() {
		return hasEscopoEscrita() && hasAuthority("EDITAR_USUARIOS_GRUPOS_PERMISSOES");
	}
		
	public boolean podeGerenciarCadastroRestaurantes() {
		return hasEscopoEscrita() && hasAuthority("EDITAR_RESTAURANTES");
	}
	
	public boolean podeGerenciarFuncionamentoRestaurante(Long restauranteId) {
		return hasEscopoEscrita() && (hasAuthority("EDITAR_RESTAURANTES") ||
				gerenciaRestaurante(restauranteId));
	}
	
	public boolean podeGerenciarPedidos(String codigoPedido) {
		return hasEscopoEscrita() && (hasAuthority("GERENCIAR_PEDIDOS") || 
				gerenciaRestauranteDoPedido(codigoPedido));
	}
	
	public boolean podePesquisarPedidos(Long clienteId, Long restauranteId) {
		return hasEscopoLeitura() && (hasAuthority("CONSULTAR_PEDIDOS") ||
				usuarioAutenticadoIgual(clienteId) || gerenciaRestaurante(restauranteId));
	}
	
	public boolean podePesquisarPedidos() {
		return hasEscopoLeitura() && isAutenticado();
	}
	
	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	private boolean isAutenticado() {
		return getAuthentication().isAuthenticated();
	}
	
	private boolean hasAuthority(String authorityName) {
		return getAuthentication().getAuthorities().stream()
				.anyMatch(authority -> authority.getAuthority().equals(authorityName));
	}
	
	private boolean hasEscopoEscrita() {
		return hasAuthority("SCOPE_WRITE");
	}
	
	private boolean hasEscopoLeitura() {
		return hasAuthority("SCOPE_READ");
	}
	
}
