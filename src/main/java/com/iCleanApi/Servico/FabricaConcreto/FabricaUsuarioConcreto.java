package com.iCleanApi.Servico.FabricaConcreto;

import com.iCleanApi.Dominio.DTO.UsuarioDTO;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Dominio.PadraoAbstrato.Fabrica.FabricaUsuario;

public class FabricaUsuarioConcreto implements FabricaUsuario {
	
	public Usuario criaUsuario (UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setEmail(dto.getEmail());
		usuario.setNome(dto.getNome());
		usuario.setSenha(dto.getSenha());
		usuario.setTokenExpo(dto.getToken());
		return usuario;
	}

}
