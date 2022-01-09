package com.DevOliga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOliga.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
