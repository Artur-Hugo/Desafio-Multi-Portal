package com.DevOliga.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.core.io.Resource;

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
		mv.addObject("usuarios", service.getUsuarios());
		mv.addObject("male", service.getCountMale());
		mv.addObject("female", service.findAllCountSexoFemale());
		mv.addObject("mediaIdadeMulher", service.mediaMulherIdade());
		mv.addObject("mediaIdadeHomem", service.mediaHomemIdade());
		
	
		
		return mv;
	}
	/*
	@GetMapping(value="/createCsv22")
	public void createCsv(HttpServletRequest request, HttpServletResponse response) {
		
		List<Usuario> users = service.getPersonagem();
		boolean isFlag = service.createCSV(users, context);
		if(isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/"+"usuario");
			service.filedownload(fullPath, response, "usuario.csv");
		}
	} */
	
	
	@GetMapping("/createCsv")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "usuarios.csv";
	    InputStreamResource file = new InputStreamResource(service.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }

	
	
	///Implementações futuras
	
	/*
	@GetMapping(value="/createCsv22")
	public void createCsv(HttpServletRequest request, HttpServletResponse response) {
		
		List<Usuario> users = service.getPersonagem();
		boolean isFlag = service.createCSV(users, context);
		if(isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/"+"usuario");
			service.filedownload(fullPath, response, "usuario.csv");
		}
	} */
	
	/*
	 @GetMapping("/download")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "tutorials.csv";
	    InputStreamResource file = new InputStreamResource(fileService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  } */

}
