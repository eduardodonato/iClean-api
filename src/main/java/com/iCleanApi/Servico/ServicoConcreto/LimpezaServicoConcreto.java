package com.iCleanApi.Servico.ServicoConcreto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.iCleanApi.Dominio.DTO.LimpezaFiltroDTO;
import com.iCleanApi.Dominio.DTO.NovaLimpezaDTO;
import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;
import com.iCleanApi.Dominio.Enum.Frequencia;
import com.iCleanApi.Dominio.PadraoAbstrato.Fabrica.FabricaLimpeza;
import com.iCleanApi.Repositorio.LimpezaRepositorio;
import com.iCleanApi.Servico.FabricaConcreto.FabricaLimpezaConcreto;
import com.iCleanApi.Servico.ServicoInteface.LimpezaServico;
import com.iCleanApi.Servico.ServicoInteface.UsuarioServico;

@Component(value = "limpezaServicoConcreto")
public class LimpezaServicoConcreto implements LimpezaServico {
	
	@Autowired
	LimpezaRepositorio repositorio;
	
	private FabricaLimpeza fabricaLimpeza = new FabricaLimpezaConcreto();
	
	@Autowired
	@Qualifier(value = "usuarioServicoConcreto")
	UsuarioServico usuarioServico;
	
	@Override
	public Limpeza executarLimpeza(Long limpezaId) {
		Optional<Limpeza> limpezaEcontrada = repositorio.findById(limpezaId);
		if (limpezaEcontrada.isEmpty()) throw new RuntimeException("Limpeza não encontrada");
		Limpeza limpeza = (Limpeza) limpezaEcontrada.get().clone();
		repositorio.delete(limpezaEcontrada.get());
		if (Frequencia.semFrequencia.equals(limpeza.getFrequencia())) return limpeza;
		limpeza.setDataProximaLimpeza(limpeza.novaDataLimpeza());
		return repositorio.save(limpeza);
	}
	
	@Override
	public Limpeza registrarLimpeza(NovaLimpezaDTO dto) {
		Usuario usuarioEncontrado = usuarioServico.encontrarPorId(dto.getUsuarioId());
		Limpeza novaLimpeza = fabricaLimpeza.criaLimpeza(dto.getDataProximaLimpeza(), dto.getFrequencia(),
				usuarioEncontrado);
		return repositorio.save(novaLimpeza);
	}
	
	@Override
	public List<Limpeza> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public List<Limpeza> listarLimpezaByUsuario(Long usuarioId) {
		Usuario usuarioEncontrado = usuarioServico.encontrarPorId(usuarioId);
		return repositorio.findByUsuario(usuarioEncontrado);
	}



	@Override
	public void excluirLimpeza(Long limpezaId) {
		Optional<Limpeza> limpezaEncontrada = repositorio.findById(limpezaId);
		if (!limpezaEncontrada.isPresent()) throw new RuntimeException("Limpeza não encontrada");
		repositorio.delete(limpezaEncontrada.get());
		
	}

	@Override
	public List<Limpeza> listarComFiltro(LimpezaFiltroDTO filtro) {
		return repositorio.listarComFiltro(filtro);
	}

}
