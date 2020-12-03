package com.iCleanApi.Servico.ServicoInteface;

import java.util.List;

import com.iCleanApi.Dominio.DTO.NovaLimpezaDTO;
import com.iCleanApi.Dominio.Entidade.Limpeza;

public interface LimpezaServico {
	
	List<Limpeza> listarTodos ();
	List<Limpeza> listarLimpezaByUsuario (Long usuarioId);
	Limpeza registrarLimpeza (NovaLimpezaDTO dto);
	Limpeza executarLimpeza (Long limpezaId);
	void excluirLimpeza (Long limpezaId);
	

}
