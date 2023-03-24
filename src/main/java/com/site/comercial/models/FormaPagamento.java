package com.site.comercial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbFormaPagamento")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormaPagamento {

	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Descricao")
	private String descricao;

	
	
	public FormaPagamento() {
		super();
	}



	public FormaPagamento(Long id, String descricao) {
		
		this.id = id;
		this.descricao = descricao;
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
	
	
	
	
}
