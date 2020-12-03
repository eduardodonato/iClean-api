package com.iCleanApi.Dominio.PadraoAbstrato.Fabrica;

import java.time.LocalDate;

import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Dominio.Enum.Frequencia;

public interface FabricaLimpeza {
	public Limpeza criaLimpeza (LocalDate dataLimpeza, Frequencia frequencia, Usuario usuario);
}
