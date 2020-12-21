package com.iCleanApi.Servico.ServicoInteface;

import java.util.List;

import javax.validation.Valid;

import com.iCleanApi.Dominio.DTO.UsuarioDTO;
import com.iCleanApi.Dominio.Entidade.Usuario;

public interface UsuarioServico {
	
	List<Usuario> listarTodos ();
	
	List<Usuario> listarTodosUsuariosDisponiveis ();
	
	Usuario criarUsuario (UsuarioDTO dto);
	
	Usuario encontrarPorId (Long usuarioId);

	Usuario login(@Valid UsuarioDTO emailSenha) throws Exception;
	
	void delete (Long usuarioId);
}
