package com.site.comercial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.comercial.models.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long>{

	List<Imagem> findByIdProduto(Long id);

}
