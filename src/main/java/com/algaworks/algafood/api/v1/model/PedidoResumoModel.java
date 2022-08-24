package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "pedidos")
@Getter
@Setter
public class PedidoResumoModel extends RepresentationModel<PedidoResumoModel>{

	@Schema(example = "390e74c6-23c5-11ed-861d-0242ac120002")
	private String codigo;
	
	@Schema(example = "99.00")
	private BigDecimal subtotal;
	
	@Schema(example = "5.50")
	private BigDecimal taxaFrete;
	
	@Schema(example = "104.50")
	private BigDecimal valorTotal;
	
	@Schema(example = "CRIADO")
	private String status;
	
	@Schema(example = "2022-08-24T16:09:35.107Z")
	private OffsetDateTime dataCriacao;
	
	private RestauranteApenasNomeModel restaurante;
	private UsuarioModel cliente;
	
}
