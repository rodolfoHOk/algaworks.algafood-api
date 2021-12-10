package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@ExtendWith(SpringExtension.class) // do junit 5 (jupiter.api) - similar ao @RunWith(SpringRunner.class) do junit 4
@SpringBootTest
class CadastroCozinhaIntegrationTest {
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	// convenção 1: givenPrecondicoes_WhenEstadoEmTeste_ThenComportamentoEsperado = 
	// 				dadoPrecondicoes_QuandoEstadoEmTeste_EntaoComportamentoEsperado
	// convenção 2: shouldComportamentoEsperado_WhenEstadoEmTeste
	//				deveComportamentoEsperado_QuandoEstadoEmTeste
	@Test
	public void deveDeveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();	
	}
	
	@Test
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		ConstraintViolationException erroEsperado = assertThrows(ConstraintViolationException.class,
				() -> cadastroCozinha.salvar(novaCozinha));
		
		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		EntidadeEmUsoException erroEsperado = assertThrows(EntidadeEmUsoException.class,
				() -> cadastroCozinha.excluir(1L));
		
		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		CozinhaNaoEncontradaException erroEsperado = assertThrows(CozinhaNaoEncontradaException.class,
				() -> cadastroCozinha.excluir(99L));
		
		assertThat(erroEsperado).isNotNull();
	}
	
}
