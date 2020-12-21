package com.iCleanApi.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iCleanApi.Dominio.DTO.LimpezaFiltroDTO;
import com.iCleanApi.Dominio.Entidade.Limpeza;
import com.iCleanApi.Dominio.Entidade.Usuario;

@Repository
public interface LimpezaRepositorio extends JpaRepository<Limpeza, Long> {
	
	public List<Limpeza> findByUsuario (Usuario usuario);
	
	@Query("Select l From Limpeza l "
		 + "Where (:#{#filtro.idUsuario} is null or l.usuario.id = :#{#filtro.idUsuario}) "
		 + "And (:#{#filtro.nome} is null or l.usuario.nome = :#{#filtro.nome}) "
		 + "And (:#{#filtro.dataLimpeza} is null or l.dataProximaLimpeza = :#{#filtro.dataLimpeza}) "
		 + "And (:#{#filtro.frequencia} is null or l.frequencia = :#{#filtro.frequencia}) ")
	public List<Limpeza> listarComFiltro (@Param("filtro") LimpezaFiltroDTO filtro);

}
