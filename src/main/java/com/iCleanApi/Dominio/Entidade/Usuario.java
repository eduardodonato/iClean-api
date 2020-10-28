package com.iCleanApi.Dominio.Entidade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Observador;
import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Sujeito;

@Entity
public class Usuario implements Observador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Senha")
	private String senha;
	
	@Column(name = "DataProximaLimpeza")
	private LocalDate dataProximaLimpeza;
	
	private Boolean Limpezaexecutada;
		
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

	public LocalDate getDataProximaLimpeza() {
		return dataProximaLimpeza;
	}

	public void setDataProximaLimpeza(LocalDate dataProximaLimpeza) {
		this.dataProximaLimpeza = dataProximaLimpeza;
	}
	public Boolean getLimpezaexecutada() {
		return Limpezaexecutada;
	}

	public void setLimpezaexecutada(Boolean limpezaexecutada) {
		Limpezaexecutada = limpezaexecutada;
	}

	@Override
	public void atualizar(Sujeito o) {
		// TODO Auto-generated method stub
			
	}

}
