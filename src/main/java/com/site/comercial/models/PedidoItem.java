package com.site.comercial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbItemPedido")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PedidoItem {

	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Quantidade")
	private Integer quantidade;

	@Column(name = "ValorUnitario")
	private Float valorUnitario;

	@Column(name = "ValorTotalItem")
	private Float valorTotalItem;

	@ManyToOne
	@JoinColumn(name = "IdPedido")
	private Pedido idPedido;

	@ManyToOne
	@JoinColumn(name = "IdProduto")
	private Produto idProduto;

	public PedidoItem() {

	}

	public PedidoItem(Long id, Integer quantidade, Float valorUnitario, Float valorTotalItem, Pedido idPedido,
			Produto idProduto) {

		this.id = id;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotalItem = valorTotalItem;
		this.idPedido = idPedido;
		this.idProduto = idProduto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Float getValorTotalItem() {
		return valorTotalItem;
	}

	public void setValorTotalItem(Float valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}

	public Pedido getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

}