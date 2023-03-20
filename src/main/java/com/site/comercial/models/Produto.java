package com.site.comercial.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbProduto")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Produto {

	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Descricao")
	private String descricao;

	@Column(name = "Valor")
	private Float valor;

	@Column(name = "QTD_Estoque")
	private Integer qtdEstoque;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "Marca")
	private String marca;

	@Column(name = "Modelo")
	private String modelo;

	@Column(name = "Garantia")
	private String garantia;

	@Column(name = "Peso")
	private Float peso;

	@Column(name = "Altura")
	private Float altura;

	@Column(name = "Largura")
	private Float largura;

	@Column(name = "Imagens")
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Imagem> imagens = new ArrayList<>();

	@Column(name = "SKU")
	private String SKU;

	@Column(name = "Fabricante")
	private String fabricante;

	@Column(name = "Condicao")
	private CondicaoProduto condicao;

	@ManyToOne
	@JoinColumn(name = "Id_Categoria")
	private Categoria categoria;

	@Column(name = "Data_Criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "Data_Atualizacao")
	private LocalDateTime dataAtualizacao;

	public Produto() {

	}

	public Produto(Long id, String descricao, Float valor, Integer qtdEstoque, String nome, String marca, String modelo,
			String garantia, Float peso, Float altura, Float largura, List<Imagem> imagens, String sKU,
			String fabricante, CondicaoProduto condicao, Categoria categoria, LocalDateTime dataAtualizacao) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.qtdEstoque = qtdEstoque;
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.garantia = garantia;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.imagens = imagens;
		this.SKU = sKU;
		this.fabricante = fabricante;
		this.condicao = condicao;
		this.categoria = categoria;
		this.dataAtualizacao = dataAtualizacao;
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

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
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
