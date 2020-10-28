package com.iCleanApi.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Servico.UsuarioServico;

@RestController
@RequestMapping("usuario")
public class UsuarioControlador {
	
	@Autowired
	UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obterUsuarios () {
		return ResponseEntity.ok(servico.listarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@RequestBody Usuario novoUsuario) {
		return ResponseEntity.ok(servico.criarUsuario(novoUsuario));
	}
}
