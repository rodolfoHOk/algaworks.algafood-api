package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
