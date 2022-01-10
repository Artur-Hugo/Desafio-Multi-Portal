package com.DevOliga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.DevOliga.model.Usuario;
import com.DevOliga.service.UsuarioService;



@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/personagens")
	public ModelAndView getPersonagem() {
		
		ModelAndView mv = new ModelAndView("usuario");
		mv.addObject("usuario", new Usuario());
		mv.addObject("usuarios", service.getPersonagem());
		mv.addObject("male", service.getCountMale());
		mv.addObject("female", service.findAllCountSexoFemale());
		mv.addObject("mediaIdadeMulher", service.mediaMulherIdade());
		mv.addObject("mediaIdadeHomem", service.mediaHomemIdade());
		
	
		
		return mv;
	}
	

}
