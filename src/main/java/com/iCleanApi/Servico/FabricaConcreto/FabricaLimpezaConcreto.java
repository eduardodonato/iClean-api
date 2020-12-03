package com.iCleanApi.Servico.FabricaConcreto;

import java.time.LocalDate;

import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Dominio.Enum.Frequencia;
import com.iCleanApi.Dominio.PadraoAbstrato.Fabrica.FabricaLimpeza;

public class FabricaLimpezaConcreto implements FabricaLimpeza {
	
	public Limpeza criaLimpeza (LocalDate dataLimpeza, Frequencia frequencia, Usuario usuario) {
		Limpeza limpeza = new Limpeza();
		limpeza.setDataProximaLimpeza(dataLimpeza);
		limpeza.setFrequencia(frequencia);
		limpeza.setUsuario(usuario);
		return limpeza;
	}

}
