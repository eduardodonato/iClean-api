package com.iCleanApi.Dominio.Entidade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.iCleanApi.Dominio.Enum.Frequencia;
import com.iCleanApi.Dominio.PadraoAbstrato.Clonavel;

@Entity
public class Limpeza implements Clonavel {
	
	public Object clone () {
		Limpeza limpezaClone = new Limpeza();
		limpezaClone.dataProximaLimpeza = this.dataProximaLimpeza;
		limpezaClone.frequencia = this.frequencia;
		limpezaClone.usuario = this.usuario;
		return limpezaClone;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private LocalDate dataProximaLimpeza;
	
	@Column
	private Frequencia frequencia;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public LocalDate novaDataLimpeza () {
		switch (frequencia) {
		case diaria:
			return dataProximaLimpeza.plusDays(1l);
		case semanal: return dataProximaLimpeza.plusDays(7l);
		case mensal: return dataProximaLimpeza.plusMonths(1l);
		default:
			return dataProximaLimpeza;
		}
	}
	
}
