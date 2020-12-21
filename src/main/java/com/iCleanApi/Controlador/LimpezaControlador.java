package com.iCleanApi.Controlador;

import java.util.List;

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

import com.iCleanApi.Dominio.DTO.LimpezaFiltroDTO;
import com.iCleanApi.Dominio.DTO.NovaLimpezaDTO;
import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Servico.ServicoInteface.LimpezaServico;

@CrossOrigin
@RestController
@RequestMapping("limpeza")
public class LimpezaControlador {
	
	@Autowired
	@Qualifier(value = "limpezaServicoConcreto")
	LimpezaServico servico;
	
	@PostMapping
	public ResponseEntity<Limpeza> marcarLimpeza (@RequestBody NovaLimpezaDTO novaLimpeza) {
		return ResponseEntity.ok(servico.registrarLimpeza(novaLimpeza));
	}
	
	@PostMapping("filtrar")
	public ResponseEntity<List<Limpeza>> filtrarLimpezas (@RequestBody LimpezaFiltroDTO filtro) {
		return ResponseEntity.ok(servico.listarComFiltro(filtro));
	}
	
	@GetMapping
	public ResponseEntity<List<Limpeza>> obterLimpeza () {
		return ResponseEntity.ok(servico.listarTodos());
	}
	
	@GetMapping("{usuarioId}")
	public ResponseEntity<List<Limpeza>> obterLimpezaByUsuarioId (@PathVariable("usuarioId") Long usuarioId ) {
		return ResponseEntity.ok(servico.listarLimpezaByUsuario(usuarioId));
	}
	
	
	@PostMapping("executar-limpeza/{limpezaId}")
	public ResponseEntity<Limpeza> executarLimpeza (@PathVariable("limpezaId") Long limpezaId) {
		return ResponseEntity.ok(servico.executarLimpeza(limpezaId));
	}
	
	@DeleteMapping("{limpezaId}")
	public ResponseEntity<?> excluir (@PathVariable("limpezaId") Long limpezaId) {
		try {
			servico.excluirLimpeza(limpezaId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
