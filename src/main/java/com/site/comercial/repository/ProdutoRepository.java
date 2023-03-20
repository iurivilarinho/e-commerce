package com.site.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.comercial.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
