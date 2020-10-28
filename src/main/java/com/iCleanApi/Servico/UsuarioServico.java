package com.iCleanApi.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	@Autowired
	UsuarioRepositorio  repositorio;
	
	public List<Usuario> listarTodos () {
		return repositorio.findAll();
	}
	
	public Usuario criarUsuario (Usuario usuario) {
		return repositorio.save(usuario);
	}
}
