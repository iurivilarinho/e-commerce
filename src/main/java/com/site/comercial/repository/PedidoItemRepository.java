package com.site.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.comercial.models.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
