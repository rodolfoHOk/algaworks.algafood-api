package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries {
	
	// Todos prefixos abaixo fazem a mesma coisa
	// List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	// List<Restaurante> getByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	// List<Restaurante> readByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	// List<Restaurante> streamByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	// @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNomeECozinha(String nome, @Param("id") Long cozinha);
	// List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinhaId);
	
	Optional<Restaurante> findFirstByNomeContaining(String nome);
	// Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome); // funciona igual acima

}
