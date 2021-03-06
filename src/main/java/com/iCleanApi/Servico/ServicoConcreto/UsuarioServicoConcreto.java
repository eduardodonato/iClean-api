package com.iCleanApi.Servico.ServicoConcreto;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.iCleanApi.Dominio.DTO.UsuarioDTO;
import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Dominio.PadraoAbstrato.Fabrica.FabricaUsuario;
import com.iCleanApi.Repositorio.UsuarioRepositorio;
import com.iCleanApi.Servico.FabricaConcreto.FabricaUsuarioConcreto;
import com.iCleanApi.Servico.ServicoInteface.LimpezaServico;
import com.iCleanApi.Servico.ServicoInteface.UsuarioServico;

@Component(value = "usuarioServicoConcreto")
public class UsuarioServicoConcreto implements UsuarioServico {
	
	@Autowired
	UsuarioRepositorio repositorio;
	
	@Autowired
	@Qualifier(value = "limpezaServicoConcreto")
	LimpezaServico limpezaServico;
	
	FabricaUsuario fabricaUsuario = new FabricaUsuarioConcreto ();
	
	public List<Usuario> listarTodos () {
		return repositorio.findAll();
	}
	
	public Usuario criarUsuario (UsuarioDTO dto) {
		validarUsuarioUnico(dto.getEmail());
		Usuario usuario = fabricaUsuario.criaUsuario(dto);
		Usuario usuarioSalvo = repositorio.save(usuario);
		return usuarioSalvo;
		
	}

	private void validarUsuarioUnico(String email) {
		Optional<Usuario> usuarioEncontrado = repositorio.findByEmail(email);
		if (usuarioEncontrado.isPresent()) throw new RuntimeException("Usuario já cadastrado");
		
	}

	@Override
	public Usuario encontrarPorId(Long usuarioId) {
		Optional<Usuario> usuarioEncontrado = repositorio.findById(usuarioId);
		if (usuarioEncontrado.isEmpty()) throw new RuntimeException("Usuario não encontrado");
		return usuarioEncontrado.get();
	}

	@Override
	public Usuario login(@Valid UsuarioDTO emailSenha) throws Exception {
		Optional<Usuario> usuarioEncontrado = repositorio.findByEmail(emailSenha.getEmail());
		if (usuarioEncontrado.isEmpty()) throw new Exception("Usuario não Encontrado");
		if (usuarioEncontrado.get().getSenha().equals(emailSenha.getSenha())) return usuarioEncontrado.get();
		throw new Exception("Email ou Senha Incorretos");
	}

	@Override
	public void delete(Long usuarioId) {
		List<Limpeza> limpezasDoUsuario = limpezaServico.listarLimpezaByUsuario(usuarioId);
		for (Limpeza limpeza : limpezasDoUsuario) {
			limpezaServico.excluirLimpeza(limpeza.getId());
		}
		repositorio.deleteById(usuarioId);
	}

	@Override
	public List<Usuario> listarTodosUsuariosDisponiveis() {
		return repositorio.listarUsuarioDisponivies();
	}
	
	
}
