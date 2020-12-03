package com.iCleanApi.Dominio.DTO;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.iCleanApi.Dominio.Enum.Frequencia;
import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Observador;
import com.iCleanApi.Servico.ClienteHttp;

public class UsuarioLimpezaDTO implements Observador {
	private Long usuarioId;
	private Long limpezaId;
	private LocalDate dataLimpeza;
	private Frequencia frequencia;
	private String tokenUsuario;
	
	@Autowired
	private ClienteHttp clienteHttp;
	
	public UsuarioLimpezaDTO(Long usuarioId, Long limpezaId, LocalDate dataLimpeza, Frequencia frequencia, String tokenUsuario) {
		super();
		this.usuarioId = usuarioId;
		this.limpezaId = limpezaId;
		this.dataLimpeza = dataLimpeza;
		this.frequencia = frequencia;
		this.tokenUsuario = tokenUsuario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataLimpeza, limpezaId, usuarioId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioLimpezaDTO other = (UsuarioLimpezaDTO) obj;
		return Objects.equals(dataLimpeza, other.dataLimpeza) && Objects.equals(limpezaId, other.limpezaId)
				&& Objects.equals(usuarioId, other.usuarioId);
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Long getLimpezaId() {
		return limpezaId;
	}
	public void setLimpezaId(Long limpezaId) {
		this.limpezaId = limpezaId;
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
	
	@Override
	public void atualizar() {
		clienteHttp.postNotification(this);
		System.out.println("Usuario Notificado :" + this);
	}
	
	@Override
	public Long getId() {
		return usuarioId;
	}
	public String getTokenUsuario() {
		return tokenUsuario;
	}
	public void setTokenUsuario(String tokenUsuario) {
		this.tokenUsuario = tokenUsuario;
	}
	@Override
	public String toString() {
		return "UsuarioLimpezaDTO [usuarioId=" + usuarioId + ", limpezaId=" + limpezaId + ", dataLimpeza=" + dataLimpeza
				+ ", tokenUsuario=" + tokenUsuario + "]";
	}
}
