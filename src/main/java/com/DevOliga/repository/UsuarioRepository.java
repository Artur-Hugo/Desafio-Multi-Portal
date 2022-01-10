package com.DevOliga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DevOliga.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public List<Usuario> findAllByOrderByNome();
	
	@Query(value="select count(nome) from usuario where sexo like 'Male'",nativeQuery=true)
	public int findAllCountSexoMale();

	@Query(value="select count(nome) from usuario where sexo like 'Female'",nativeQuery=true)
	public int findAllCountSexoFemale();
	
}
