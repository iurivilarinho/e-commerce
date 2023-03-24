package com.site.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.comercial.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
