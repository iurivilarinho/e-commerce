package com.site.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.comercial.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
