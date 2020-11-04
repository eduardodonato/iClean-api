package com.iCleanApi.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iCleanApi.Dominio.Entidade.Usuario;

@Component @EnableScheduling
public class RotinaServico {
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	@Scheduled(fixedDelay = 120000l)
	private void adicionarUsuarioRotina () {
		List<Usuario> usuarios = usuarioServico.listarTodos();
		for (Usuario usuario : usuarios) {
			try {
				usuarioServico.adicionar(usuario);
			} catch (Exception e) {
				System.out.print(e.getMessage() + "Erro");
			}
		}
	}
	@Scheduled(fixedDelay = 12000l)
	private void notificarUsuarios () {
		usuarioServico.notificar();
	}

}
