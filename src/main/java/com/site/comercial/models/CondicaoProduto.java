package com.site.comercial.models;

public enum CondicaoProduto {
	NOVO("Novo"), USADO("Usado"), RECONDICIONADO("Recondicionado");

	private final String descricao;

	CondicaoProduto(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
