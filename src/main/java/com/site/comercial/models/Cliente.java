package com.site.comercial.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbCliente")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "Telefone")
	private String telefone;

	@JoinColumn(name = "IdEndereco")
	@OneToMany(mappedBy = "id")
	private List<Endereco> idEndereco;

	public Cliente() {

	}

	public Cliente(Long id, String nome, String email, String telefone, List<Endereco> idEndereco) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.idEndereco = idEndereco;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Endereco> getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(List<Endereco> idEndereco) {
		this.idEndereco = idEndereco;
	}

}
