package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.RestauranteController;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.core.security.AlgaSecurity;
import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class RestauranteModelAssembler extends RepresentationModelAssemblerSupport<Restaurante, RestauranteModel>{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	@Autowired
	private AlgaSecurity algaSecurity;
	
	public RestauranteModelAssembler() {
		super(RestauranteController.class, RestauranteModel.class);
	}
	
	@Override
	public RestauranteModel toModel(Restaurante restaurante) {
		RestauranteModel restauranteModel = createModelWithId(restaurante.getId(), restaurante);
		
		modelMapper.map(restaurante, restauranteModel);
		
		if (algaSecurity.podeConsultarRestaurantes()) {
			restauranteModel.add(algaLinks.linkToRestaurantes("restaurantes"));
		
			restauranteModel.add(algaLinks.linkToRestauranteProdutos(restauranteModel.getId(), "produtos"));
		
			restauranteModel.add(algaLinks
					.linkToFormasPagamentoRestaurante(restauranteModel.getId(), "formas-pagamento"));
		}
		
		if (algaSecurity.podeGerenciarCadastroRestaurantes()) {
			restauranteModel.add(algaLinks.linkToResponsaveisRestaurante(restauranteModel.getId(), "responsaveis"));

			if (restaurante.ativacaoPermitida())
				restauranteModel.add(algaLinks.linkToAtivarRestaurante(restauranteModel.getId(), "ativar"));
			
			if (restaurante.inativacaoPermitida())
				restauranteModel.add(algaLinks.linkToInativarRestaurante(restauranteModel.getId(), "inativar"));
		}

		if (algaSecurity.podeGerenciarFuncionamentoRestaurante(restaurante.getId())) {
			if (restaurante.aberturaPermitida())
				restauranteModel.add(algaLinks.linkToAbrirRestaurante(restauranteModel.getId(), "abrir"));
			
			if (restaurante.fechamentoPermitido())
				restauranteModel.add(algaLinks.linkToFecharRestaurante(restauranteModel.getId(), "fechar"));
		}
		
		if (algaSecurity.podeConsultarCozinhas())
			restauranteModel.getCozinha().add(algaLinks.linkToCozinha(restauranteModel.getCozinha().getId()));
		
		if (algaSecurity.podeConsultarCidades())
			if (restaurante.getEndereco() != null && restaurante.getEndereco().getCidade() != null)
				restauranteModel.getEndereco().getCidade().add(algaLinks
						.linkToCidade(restauranteModel.getEndereco().getCidade().getId()));
		
		return restauranteModel;
	}
	
}
