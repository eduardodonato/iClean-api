package com.iCleanApi.Dominio.DTO;

public class DataLimpezaDTO {
	
	private UsuarioLimpezaDTO limpeza;
	
	public DataLimpezaDTO(UsuarioLimpezaDTO limpeza) {
		super();
		this.limpeza = limpeza;
	}

	public UsuarioLimpezaDTO getLimpeza() {
		return limpeza;
	}

	public void setLimpeza(UsuarioLimpezaDTO limpeza) {
		this.limpeza = limpeza;
	}

}
