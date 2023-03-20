package com.site.comercial.controller.dto;

import com.site.comercial.models.Categoria;

public class CategoriaDto {

	private String nome;
	private String descricao;

	public CategoriaDto(Categoria categoria) {

		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
