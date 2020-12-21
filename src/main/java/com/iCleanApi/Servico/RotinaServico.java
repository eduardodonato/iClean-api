package com.iCleanApi.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Servico.ServicoInteface.LimpezaServico;

@Component @EnableScheduling
public class RotinaServico {
	
	private RotinaSujeito rotinaSujeito = new RotinaSujeito();
	
	@Autowired
	@Qualifier(value = "limpezaServicoConcreto")
	LimpezaServico limpezaServico;
	
	@Scheduled(fixedDelay = 60000l)
	private void adicionarUsuarioRotina () {
		
		List<Limpeza> limpezas = limpezaServico.listarTodos();
		for (Limpeza limpeza : limpezas) {
			try {
				rotinaSujeito.adicionarUsuarioLimpeza(limpeza);
			} catch (Exception e) {
				System.out.print(e.getMessage() + "Erro");
			}
		}
	}
	@Scheduled(fixedDelay = 12000l)
	private void notificarUsuarios () {
		rotinaSujeito.notificar();
	}

}