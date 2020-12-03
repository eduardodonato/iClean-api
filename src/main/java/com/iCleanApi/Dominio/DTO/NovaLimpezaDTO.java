package com.iCleanApi.Dominio.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.iCleanApi.Dominio.Enum.Frequencia;

public class NovaLimpezaDTO implements Serializable {
	
	private static final long serialVersionUID = -647731238346000156L;
	
	@NotNull
	private LocalDate dataProximaLimpeza;
	
	@NotNull
	private Frequencia frequencia;
	
	@NotNull
	private Long usuarioId;
	
	public LocalDate getDataProximaLimpeza() {
		return dataProximaLimpeza;
	}
	public void setDataProximaLimpeza(LocalDate dataProximaLimpeza) {
		this.dataProximaLimpeza = dataProximaLimpeza;
	}
	public Frequencia getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	

}
