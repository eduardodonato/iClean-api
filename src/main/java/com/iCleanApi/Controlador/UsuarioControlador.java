package com.iCleanApi.Controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iCleanApi.Dominio.DTO.UsuarioDTO;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Servico.ServicoInteface.UsuarioServico;

@CrossOrigin
@RestController
@RequestMapping("usuario")
public class UsuarioControlador {
	
	@Autowired
	@Qualifier(value = "usuarioServicoConcreto")
	UsuarioServico servico;
	
	@PostMapping("login")
	public ResponseEntity<Usuario> login (@RequestBody UsuarioDTO emailSenha) {
		try {
			return ResponseEntity.ok(servico.login(emailSenha));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obterUsuarios () {
		return ResponseEntity.ok(servico.listarTodos());
	}
	
	@GetMapping("disponiveis")
	public ResponseEntity<List<Usuario>> obterUsuariosDisponiveis () {
		return ResponseEntity.ok(servico.listarTodosUsuariosDisponiveis());
	}
	
	@GetMapping("{usuarioId}")
	public ResponseEntity<Usuario> obterUsuarioPorId (@PathVariable("usuarioId") Long usuarioId) {
		return ResponseEntity.ok(servico.encontrarPorId(usuarioId));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@RequestBody @Valid UsuarioDTO novoUsuario) {
		return ResponseEntity.ok(servico.criarUsuario(novoUsuario));
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
