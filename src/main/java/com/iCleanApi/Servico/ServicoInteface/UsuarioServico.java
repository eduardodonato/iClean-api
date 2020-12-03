package com.iCleanApi.Servico.ServicoInteface;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.iCleanApi.Dominio.DTO.UsuarioDTO;
import com.iCleanApi.Dominio.Entidade.Usuario;

public interface UsuarioServico {
	
	List<Usuario> listarTodos ();
	
	Usuario criarUsuario (UsuarioDTO dto);
	
	Optional<Usuario> encontrarPorId (Long usuarioId);

	Usuario login(@Valid UsuarioDTO emailSenha) throws Exception;
	
	void delete (Long usuarioId);
}
