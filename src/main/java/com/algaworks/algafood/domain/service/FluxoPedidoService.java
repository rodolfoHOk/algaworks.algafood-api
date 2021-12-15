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
	public void confirmar(String codigo) {
		Pedido pedido = emissaoPedido.buscar(codigo);
		
		pedido.confirmar();
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
