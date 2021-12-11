package com.algaworks.algafood.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.model.EstadoModel;
import com.algaworks.algafood.domain.model.Estado;

@Component
public class EstadoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EstadoModel toModel(Estado Estado) {
		return modelMapper.map(Estado, EstadoModel.class);
	}
	
	public List<EstadoModel> toCollectionModel(List<Estado> estados) {
		return estados.stream()
				.map(estado -> toModel(estado))
				.toList();
	}
}
