package com.iCleanApi.Servico;

import java.time.LocalDate;

import com.iCleanApi.Dominio.DTO.UsuarioLimpezaDTO;
import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Sujeito;

public class RotinaSujeito extends Sujeito {
	
	public void adicionarUsuarioLimpeza (Limpeza limpeza) {
		if (deveAdicionarLimpeza(limpeza)) adicionar(criaUsuarioLimpeza(limpeza));
	}
	private UsuarioLimpezaDTO criaUsuarioLimpeza(Limpeza limpeza) {
		return new UsuarioLimpezaDTO(limpeza.getUsuario().getId(), limpeza.getId(),
				limpeza.getDataProximaLimpeza(), limpeza.getFrequencia(), limpeza.getUsuario().getTokenExpo());
	}
	private boolean deveAdicionarLimpeza(Limpeza limpeza) {
		LocalDate dataAtual = LocalDate.now();
		return dataAtual.equals(limpeza.getDataProximaLimpeza()); 
	}
	
	public void resetarObservadores () {
		this.getObservadores().reset();
	}
}
