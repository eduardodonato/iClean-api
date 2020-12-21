package com.iCleanApi.Dominio.DTO;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.iCleanApi.Dominio.Enum.Frequencia;
import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Observador;

public class UsuarioLimpezaDTO implements Observador {
	private final String url = "https://exp.host/--/api/v2/push/send";
	private Long usuarioId;
	private Long limpezaId;
	private LocalDate dataLimpeza;
	private Frequencia frequencia;
	private String tokenUsuario;
	
	@Override
	public void atualizar() {
		enviarNotificacao();
		System.out.println("Usuario Notificado :" + this);
	}
	
	@Override
	public Long getId() {
		return usuarioId;
	}
	
	public UsuarioLimpezaDTO () {}
	
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
	
	private void enviarNotificacao() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		RestTemplate restTemplate = restTemplateBuilder.build();
		PostNotificationDTO dto = new PostNotificationDTO();
		DataLimpezaDTO dataDto = new DataLimpezaDTO(this);
		dto.setTitle("Sua Limpeza é Hoje");
		dto.setBody("Clique aqui quando a executá-la");
		dto.setTo(getTokenUsuario());
		dto.setData(dataDto);
		restTemplate.postForLocation(url, dto);
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
