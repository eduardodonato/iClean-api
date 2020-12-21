package com.iCleanApi.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iCleanApi.Dominio.Entidade.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail (String email);
	
	@Query("Select usuario from Usuario usuario where usuario.tokenExpo != null")
	public List<Usuario> listarUsuarioDisponivies ();
}
