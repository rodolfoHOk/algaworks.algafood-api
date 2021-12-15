package com.algaworks.algafood.domain.model;

import java.util.Arrays;
import java.util.List;

public enum StatusPedido {
	
	CRIADO("Criado"),
	CONFIRMADO("Confimado", CRIADO),
	ENTREGUE("Entregue", CONFIRMADO),
	CANCELADO("Cancelado", CRIADO);
	
	private String descricao;
	private List<StatusPedido> statusAnteriores;
	
	StatusPedido(String descricao) {
		this.descricao = descricao;
	}
	
	StatusPedido(String descricao, StatusPedido... statusAnteriores) {
		this.descricao = descricao;
		this.statusAnteriores = Arrays.asList(statusAnteriores);
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public boolean naoPodeAlterarPara(StatusPedido novoStatus) {
		return !novoStatus.statusAnteriores.contains(this);
	}
	
}
