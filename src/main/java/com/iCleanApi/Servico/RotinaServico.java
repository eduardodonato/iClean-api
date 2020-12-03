package com.iCleanApi.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Servico.ServicoInteface.LimpezaServico;
import com.iCleanApi.Servico.ServicoInteface.UsuarioServico;

@Component @EnableScheduling
public class RotinaServico {
	
	private LimpezaSujeito limpezaSujeito = new LimpezaSujeito();
	
	@Autowired
	@Qualifier(value = "limpezaServicoConcreto")
	LimpezaServico limpezaServico;
	
	@Scheduled(fixedDelay = 60000l)
	private void adicionarUsuarioRotina () {
		
		List<Limpeza> limpezas = limpezaServico.listarTodos();
		for (Limpeza limpeza : limpezas) {
			try {
				limpezaSujeito.adicionarUsuarioLimpeza(limpeza);
			} catch (Exception e) {
				System.out.print(e.getMessage() + "Erro");
			}
		}
	}
	@Scheduled(fixedDelay = 12000l)
	private void notificarUsuarios () {
		limpezaSujeito.notificar();
	}

}