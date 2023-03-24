package com.site.comercial.models;

import java.time.LocalDateTime;

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
@Table(name = "tbPedido")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pedido {

	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DataCadastro")
	private LocalDateTime dataPedido;

	@Column(name = "ValorTotal")
	private Float valorTotal;

	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente idCliente;

	public Pedido() {

	}

	public Pedido(Long id, LocalDateTime dataPedido, Float valorTotal, Cliente idCliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.idCliente = idCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

}
