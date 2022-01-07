package com.algaworks.algafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.AlgaLinks;
import com.algaworks.algafood.api.controller.PedidoController;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoModelAssembler extends RepresentationModelAssemblerSupport<Pedido, PedidoModel>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	public PedidoModelAssembler() {
		super(PedidoController.class, PedidoModel.class);
	}
	
	@Override
	public PedidoModel toModel(Pedido pedido) {
		PedidoModel pedidoModel = createModelWithId(pedido.getCodigo(), pedido);
		
		modelMapper.map(pedido, pedidoModel);
		
		pedidoModel.add(algaLinks.linkToPedidos());
		
		if (pedido.podeSerConfirmado()) 
			pedidoModel.add(algaLinks.linkToConfirmacaoPedido(pedido.getCodigo(), "confirmar"));
		
		if (pedido.podeSerCancelado())
			pedidoModel.add(algaLinks.linkToCancelamentoPedido(pedido.getCodigo(), "cancelar"));
		
		if (pedido.podeSerEntregue())
			pedidoModel.add(algaLinks.linkToEntregaPedido(pedido.getCodigo(), "entregue"));
		
		pedidoModel.getEndereco().getCidade().add(algaLinks.
				linkToCidade(pedidoModel.getEndereco().getCidade().getId()));
		
		pedidoModel.getRestaurante().add(algaLinks.linkToRestaurante(pedidoModel.getRestaurante().getId()));
		
		pedidoModel.getCliente().add(algaLinks.linkToUsuario(pedidoModel.getCliente().getId()));
		
		pedidoModel.getFormaPagamento().add(algaLinks.linkToFormaPagamento(pedidoModel.getFormaPagamento().getId()));
		
		pedidoModel.getItens().forEach(item -> {
			item.add(algaLinks.linkToProduto(pedidoModel.getRestaurante().getId(), item.getProdutoId(), "produto"));
		});
		
		return pedidoModel;
	}
	
}
