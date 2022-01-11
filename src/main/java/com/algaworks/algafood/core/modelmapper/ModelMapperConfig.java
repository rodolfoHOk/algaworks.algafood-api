package com.algaworks.algafood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.api.v1.model.EnderecoModel;
import com.algaworks.algafood.api.v1.model.input.ItemPedidoInput;
import com.algaworks.algafood.api.v2.model.input.CidadeInputV2;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.ItemPedido;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
		modelMapper.createTypeMap(CidadeInputV2.class, Cidade.class)
			.addMappings(mapper -> mapper.skip(Cidade::setId)); // para idEstado não ir para o id da cidade

		modelMapper.createTypeMap(ItemPedidoInput.class, ItemPedido.class)
	    	.addMappings(mapper -> mapper.skip(ItemPedido::setId)); // para produtoId não ir para o itemPedidoId
		
		var enderecoToenderecoModelTypeMap = modelMapper.createTypeMap(Endereco.class, EnderecoModel.class);
		enderecoToenderecoModelTypeMap.<String>addMapping(
				src -> src.getCidade().getEstado().getNome(),
				(dest, value) -> dest.getCidade().setEstado(value));		
		
		return modelMapper;
	}
}
