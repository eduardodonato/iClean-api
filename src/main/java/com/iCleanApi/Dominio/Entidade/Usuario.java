package com.iCleanApi.Dominio.Entidade;

import java.time.LocalDate;

import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Observador;
import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Sujeito;

public class Usuario implements Observador {

	private String nome;
	private String email;
	private String senha;
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
	@Override
	public void atualizar(Sujeito o) {
		// TODO Auto-generated method stub
			
	}

}
