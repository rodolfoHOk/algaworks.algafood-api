package com.algaworks.algafood.domain.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.PedidoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.PedidoRepository;

@Service
public class CadastroPedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamento;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuario;
	
	@Autowired
	private CadastroCidadeService cadastroCidade;
	
	@Autowired
	private CadastroProdutoService cadastroProduto;
	
	public Pedido buscar(Long pedidoId) {
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new PedidoNaoEncontradoException(pedidoId));
	}
	
	@Transactional
	public Pedido emitir(Pedido pedido) {
		validarPedido(pedido);
		validarItens(pedido);
		
		pedido.setTaxaFrete(pedido.getRestaurante().getTaxaFrete());
		pedido.calcularSubtotalETotal();
		
		return pedidoRepository.save(pedido);
	}

	private void validarPedido(Pedido pedido) {
		Cidade cidade = cadastroCidade.buscar(pedido.getEndereco().getCidade().getId());
		pedido.getEndereco().setCidade(cidade);
		Usuario cliente = cadastroUsuario.buscar(pedido.getCliente().getId());
		pedido.setCliente(cliente);
		Restaurante restaurante = cadastroRestaurante.buscar(pedido.getRestaurante().getId());
		pedido.setRestaurante(restaurante);
		FormaPagamento formaPagamento = cadastroFormaPagamento.buscar(pedido.getFormaPagamento().getId());
		if (restaurante.naoAceitaFormaPagamento(formaPagamento)) {
			throw new NegocioException(String.format("Forma de pagamento '%s' não é aceita por esse restaurante.",
					formaPagamento.getDescricao()));
		}
		pedido.setFormaPagamento(formaPagamento);
	}
	
	private void validarItens(Pedido pedido) {
		Long restauranteId = pedido.getRestaurante().getId();
		
		pedido.getItens().forEach(item -> {
			Produto produto = cadastroProduto.buscar(restauranteId, item.getProduto().getId());
			item.setProduto(produto);
			item.setPedido(pedido);
			item.setPrecoUnitario(produto.getPreco());
			BigDecimal precoTotal = item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade()));
			item.setPrecoTotal(precoTotal);
		});
		
	}
	
}
