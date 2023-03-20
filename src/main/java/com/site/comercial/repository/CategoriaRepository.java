package com.site.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.comercial.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
