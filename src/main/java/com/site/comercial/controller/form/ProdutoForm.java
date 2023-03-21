package com.site.comercial.controller.form;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.multipart.MultipartFile;

import com.site.comercial.models.Categoria;
import com.site.comercial.models.CondicaoProduto;
import com.site.comercial.models.Imagem;
import com.site.comercial.models.Produto;
import com.site.comercial.repository.CategoriaRepository;
import com.site.comercial.repository.ProdutoRepository;

public class ProdutoForm {
	private String nome;
	private String descricao;
	private Float valor;
	private Integer qtdEstoque;
	private String marca;
	private String modelo;
	private String garantia;
	private Float peso;
	private Float altura;
	private Float largura;
	private Long categoriaId;
	private List<MultipartFile> imagens = new ArrayList<>();
	private String fabricante;
	private String condicao;
	private String SKU;

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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public List<MultipartFile> getImagens() {
		return imagens;
	}

	public void setImagens(List<MultipartFile> imagens) {
		this.imagens = imagens;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public Produto salvar(CategoriaRepository categoriaRepository) {

		Produto produto = new Produto();
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com o ID: " + categoriaId));

		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setQtdEstoque(qtdEstoque);
		produto.setMarca(marca);
		produto.setModelo(modelo);
		produto.setGarantia(garantia);
		produto.setPeso(peso);
		produto.setAltura(altura);
		produto.setLargura(largura);
		produto.setFabricante(fabricante);
		produto.setCondicao(CondicaoProduto.valueOf(condicao));
		produto.setSKU(SKU);
		produto.setCategoria(categoria);

		return produto;
	}

	public Produto atualizar(Long id, CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, List<Imagem> imagens) {

		Produto produto = produtoRepository.getReferenceById(id);
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com o ID: " + categoriaId));

		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setQtdEstoque(qtdEstoque);
		produto.setMarca(marca);
		produto.setModelo(modelo);
		produto.setGarantia(garantia);
		produto.setPeso(peso);
		produto.setAltura(altura);
		produto.setLargura(largura);
		produto.setFabricante(fabricante);
		produto.setCondicao(CondicaoProduto.valueOf(condicao));
		produto.setSKU(SKU);
		produto.setDataAtualizacao(LocalDateTime.now());
		produto.setCategoria(categoria);
		produto.setImagens(imagens);

		return produto;
	}
}