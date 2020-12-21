package com.iCleanApi.Dominio.DTO;

import java.time.LocalDate;

import com.iCleanApi.Dominio.Enum.Frequencia;

public class LimpezaFiltroDTO {

	Long idUsuario;
	String nome;
	LocalDate dataLimpeza;
	Frequencia frequencia;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataLimpeza() {
		return dataLimpeza;
	}
	public void setDataLimpeza(LocalDate dataLimpeza) {
		this.dataLimpeza = dataLimpeza;
	}
	public Frequencia getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	
}
