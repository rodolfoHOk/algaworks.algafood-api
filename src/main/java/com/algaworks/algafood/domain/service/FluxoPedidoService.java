package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.service.EnvioEmailService.Mensagem;

@Service
public class FluxoPedidoService {

	@Autowired
	private EmissaoPedidoService emissaoPedido;
	
	@Autowired
	private EnvioEmailService envioEmail;

	@Transactional
	public void confirmar(String codigo) {
		Pedido pedido = emissaoPedido.buscar(codigo);
		
		pedido.confirmar();
		
		var mensagem = Mensagem.builder()
				.assunto(pedido.getRestaurante().getNome() + " - Pedido confirmado")
				.corpo("O pedido de código <strong>" + pedido.getCodigo() + "</strong> foi confirmado!")
				.destinatario(pedido.getCliente().getEmail())
				.build();
		
		envioEmail.enviar(mensagem);
	}
	
	@Transactional
	public void cancelar(String codigo) {
		Pedido pedido = emissaoPedido.buscar(codigo);
		
		pedido.cancelar();
	}
	
	@Transactional
	public void entregue(String codigo) {
		Pedido pedido = emissaoPedido.buscar(codigo);
		
		pedido.entregue();
	}
}
