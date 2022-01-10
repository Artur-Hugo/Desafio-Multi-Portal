package com.DevOliga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DevOliga.model.Usuario;
import com.DevOliga.repository.UsuarioRepository;


@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	
	public List<Usuario> getPersonagem(){
		return repository.findAllByOrderByNome();
	}
	
	public int getCountMale(){
		return repository.findAllCountSexoMale();
	}
	
	public int findAllCountSexoFemale() {
		return repository.findAllCountSexoFemale();
	}
	
	public int mediaHomemIdade() {
		return repository.mediaHomemIdade();
	}
	
	public int mediaMulherIdade() {
		return repository.mediaMulherIdade();
	}
}
