package com.iCleanApi.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;

@Repository
public interface LimpezaRepositorio extends JpaRepository<Limpeza, Long> {
	
	public List<Limpeza> findByUsuario (Usuario usuario);

}
