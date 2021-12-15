package com.algaworks.algafood.domain.model;

import lombok.Getter;

@Getter
public enum StatusPedido {
	
	CRIADO("Criado"),
	CONFIRMADO("Confimado"),
	ENTREGUE("Entregue"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	StatusPedido(String descricao) {
		this.descricao = descricao;
	}
	
}
