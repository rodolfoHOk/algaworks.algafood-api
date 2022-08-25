package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoProdutoModel extends RepresentationModel<FotoProdutoModel>{
	
	@Schema(example = "0e4940c8-44d7-4946-9686-fa23a39289ab_Prime-Rib.jpg")
	private String nomeArquivo;
	
	@Schema(example = "Prime Rib ao ponto")
	private String descricao;
	
	@Schema(example = "image/jpeg")
	private String contentType;
	
	@Schema(example = "202912")
	private Long tamanho;
	
}
