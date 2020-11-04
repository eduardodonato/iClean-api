package com.iCleanApi.Servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Observador;
import com.iCleanApi.Dominio.PadraoAbstrato.Observador.Sujeito;
import com.iCleanApi.Repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico extends Sujeito {
	
	@Autowired
	UsuarioRepositorio  repositorio;
	
	public List<Usuario> listarTodos () {
		return repositorio.findAll();
	}
	
	public Usuario criarUsuario (Usuario usuario) {
		usuario.setDataProximaLimpeza(LocalDate.now());
		return repositorio.save(usuario);
	}
	
	@Override
	public void adicionar (Observador o) throws Exception {
		LocalDate data = LocalDate.now();
		if (o instanceof Usuario) {
			Usuario usuario = (Usuario) o;
			LocalDate dataUsuario = usuario.getDataProximaLimpeza();
			if (dataUsuario != null && dataUsuario.equals(data)) getObservadores().add(usuario);
		} else throw new Exception("Observador Inválido");
	}
	
	public void resetarObservadores () {
		this.setObservadores(new ArrayList<>());
	}
}
