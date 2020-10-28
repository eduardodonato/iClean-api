package com.iCleanApi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iCleanApi.Dominio.Entidade.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
