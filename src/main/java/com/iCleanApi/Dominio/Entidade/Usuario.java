package com.iCleanApi.Dominio.Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Email", unique = true)
	private String email;
	
	@Column(name = "Senha")
	private String senha;
	
	@Column(name = "Token")
	private String tokenExpo;
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTokenExpo() {
		return tokenExpo;
	}

	public void setTokenExpo(String tokenExpo) {
		this.tokenExpo = tokenExpo;
	}

}
