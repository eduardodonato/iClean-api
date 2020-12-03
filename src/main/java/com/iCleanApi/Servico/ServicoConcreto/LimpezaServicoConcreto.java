package com.iCleanApi.Servico.ServicoConcreto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.iCleanApi.Dominio.DTO.NovaLimpezaDTO;
import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;
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
	public List<Limpeza> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public List<Limpeza> listarLimpezaByUsuario(Long usuarioId) {
		Optional<Usuario> usuarioEncontrado = usuarioServico.encontrarPorId(usuarioId);
		if (!usuarioEncontrado.isPresent()) throw new RuntimeException("Usuario não encontrado");
		return repositorio.findByUsuario(usuarioEncontrado.get());
	}

	@Override
	public Limpeza registrarLimpeza(NovaLimpezaDTO dto) {
		Optional<Usuario> usuarioEncontrado = usuarioServico.encontrarPorId(dto.getUsuarioId());
		if (!usuarioEncontrado.isPresent()) throw new RuntimeException("Usuario não encontrado");
		Limpeza novaLimpeza = fabricaLimpeza.criaLimpeza(dto.getDataProximaLimpeza(), dto.getFrequencia(), usuarioEncontrado.get());
		return repositorio.save(novaLimpeza);
	}

	@Override
	public Limpeza executarLimpeza(Long limpezaId) {
		Optional<Limpeza> limpezaEcontrada = repositorio.findById(limpezaId);
		if (limpezaEcontrada.isEmpty()) throw new RuntimeException("Limpeza não encontrada");
		Limpeza limpeza = (Limpeza) limpezaEcontrada.get().clone();
		repositorio.delete(limpezaEcontrada.get());
		limpeza.setDataProximaLimpeza(limpeza.novaDataLimpeza());
		return repositorio.save(limpeza);
	}

	@Override
	public void excluirLimpeza(Long limpezaId) {
		Optional<Limpeza> limpezaEncontrada = repositorio.findById(limpezaId);
		if (!limpezaEncontrada.isPresent()) throw new RuntimeException("Limpeza não encontrada");
		repositorio.delete(limpezaEncontrada.get());
		
	}

}
