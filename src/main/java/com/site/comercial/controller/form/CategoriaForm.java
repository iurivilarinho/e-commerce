package com.site.comercial.controller.form;

import java.time.LocalDateTime;

import com.site.comercial.models.Categoria;

public class CategoriaForm {

	private String nome;
	private String descricao;

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

	public Categoria salvar() {
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoria.setDescricao(descricao);

		return categoria;

	}

	public Categoria atualizar() {
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoria.setDescricao(descricao);
		categoria.setDataAtualizacao(LocalDateTime.now());

		return categoria;

	}

}
