package com.DevOliga.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginUsuarioController {

	@RequestMapping("/login")
	public ModelAndView login() { 
		ModelAndView mv = new ModelAndView("login");
		return mv;}
	
	@RequestMapping("/oi")
	public String Pagina() {
		return"pagina";
	}
	   
	
}
