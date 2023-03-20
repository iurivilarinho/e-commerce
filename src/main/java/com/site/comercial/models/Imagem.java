package com.site.comercial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbImagens")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "contentType")
	private String contentType;

	@Lob
	@Column(name = "Imagem")
	private byte[] imagem;

	@ManyToOne
	@JoinColumn(name = "Id_produto")
	private Produto produto;

	public Imagem() {

	}

	public Imagem(Long id, String nome, String contentType, byte[] imagem, Produto produto) {

		this.nome = nome;
		this.contentType = contentType;
		this.imagem = imagem;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
