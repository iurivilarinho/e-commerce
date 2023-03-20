package com.site.comercial.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.site.comercial.models.Categoria;
import com.site.comercial.models.CondicaoProduto;
import com.site.comercial.models.Imagem;
import com.site.comercial.models.Produto;

public class ProdutoDto {
	private Long id;
	private String descricao;
	private Float valor;
	private Integer qtdEstoque;
	private String nome;
	private String marca;
	private String modelo;
	private String garantia;
	private Float peso;
	private Float altura;
	private Float largura;
	private CondicaoProduto condicao;
	private Categoria categoria;
	private List<Imagem> fotos;
	private String SKU;
	private String fabricante;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private LocalDateTime dataAtualizacao;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
		this.qtdEstoque = produto.getQtdEstoque();
		this.nome = produto.getNome();
		this.marca = produto.getMarca();
		this.modelo = produto.getModelo();
		this.garantia = produto.getGarantia();
		this.peso = produto.getPeso();
		this.altura = produto.getAltura();
		this.largura = produto.getLargura();
		this.condicao = produto.getCondicao();
		this.categoria = produto.getCategoria();
		this.fotos = produto.getImagens();
		this.SKU = produto.getSKU();
		this.fabricante = produto.getFabricante();
		this.dataCriacao = produto.getDataCriacao();
		this.dataAtualizacao = produto.getDataAtualizacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getLargura() {
		return largura;
	}

	public void setLargura(Float largura) {
		this.largura = largura;
	}

	public CondicaoProduto getCondicao() {
		return condicao;
	}

	public void setCondicao(CondicaoProduto condicao) {
		this.condicao = condicao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Imagem> getFotos() {
		return fotos;
	}

	public void setFotos(List<Imagem> fotos) {
		this.fotos = fotos;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
