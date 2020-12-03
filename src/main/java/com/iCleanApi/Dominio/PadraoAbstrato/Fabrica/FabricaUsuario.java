package com.iCleanApi.Dominio.PadraoAbstrato.Fabrica;

import com.iCleanApi.Dominio.DTO.UsuarioDTO;
import com.iCleanApi.Dominio.Entidade.Usuario;

public interface FabricaUsuario {
	public Usuario criaUsuario (UsuarioDTO dto);
}
