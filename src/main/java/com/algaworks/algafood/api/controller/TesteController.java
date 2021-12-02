package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
		return cozinhaRepository.findVariasByNome(nome);
	}
	
	@GetMapping("/cozinhas/unica-por-nome")
	public ResponseEntity<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome) {
		Optional<Cozinha> cozinha = cozinhaRepository.findByNome(nome);
		
		if (cozinha.isPresent()) {
			return ResponseEntity.ok(cozinha.get());
		}
		
		return ResponseEntity.notFound().build();
	}

}
