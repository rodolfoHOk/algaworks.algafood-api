package com.algaworks.algafood.api.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoProdutoModel extends RepresentationModel<FotoProdutoModel>{
	
	private String nomeArquivo;
	private String descricao;
	private String contentType;
	private Long tamanho;
	
}
