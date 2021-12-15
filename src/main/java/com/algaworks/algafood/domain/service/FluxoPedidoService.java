package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Pedido;

@Service
public class FluxoPedidoService {

	@Autowired
	private EmissaoPedidoService emissaoPedido;

	@Transactional
	public void confirmar(Long pedidoId) {
		Pedido pedido = emissaoPedido.buscar(pedidoId);
		
		pedido.confirmar();
	}
	
	@Transactional
	public void cancelar(Long pedidoId) {
		Pedido pedido = emissaoPedido.buscar(pedidoId);
		
		pedido.cancelar();
	}
	
	@Transactional
	public void entregue(Long pedidoId) {
		Pedido pedido = emissaoPedido.buscar(pedidoId);
		
		pedido.entregue();
	}
}
