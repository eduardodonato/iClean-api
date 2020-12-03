package com.iCleanApi.Controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iCleanApi.Dominio.DTO.UsuarioDTO;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Servico.ServicoInteface.UsuarioServico;

@RestController
@RequestMapping("usuario")
public class UsuarioControlador {
	
	@Autowired
	@Qualifier(value = "usuarioServicoConcreto")
	UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obterUsuarios () {
		return ResponseEntity.ok(servico.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@RequestBody @Valid UsuarioDTO novoUsuario) {
		return ResponseEntity.ok(servico.criarUsuario(novoUsuario));
	}
	
	@PostMapping("login")
	public ResponseEntity<Usuario> login (@RequestBody UsuarioDTO emailSenha) {
		try {
			return ResponseEntity.ok(servico.login(emailSenha));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteById (@RequestBody Long usuarioId) {
		try {
			servico.delete(usuarioId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
