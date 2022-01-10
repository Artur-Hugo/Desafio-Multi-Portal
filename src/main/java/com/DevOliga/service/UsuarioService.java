package com.DevOliga.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import com.bezkoder.spring.files.csv.helper.CSVHelper;

import com.DevOliga.helper.CSVHelper;
import com.DevOliga.model.Usuario;
import com.DevOliga.repository.UsuarioRepository;

import au.com.bytecode.opencsv.CSVWriter;


@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	private ServletContext context;
	
	
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
	
	public boolean createCSV(List<Usuario> usuarios, ServletContext context) {
		String filePath = context.getRealPath("/resources/reports");
		boolean exists = new File(filePath).exists();
		if(!exists) {
			new File(filePath).mkdir();
		}
		File file = new File(filePath+"/"+File.separator+"usuario.csv");
		try {
			FileWriter fileWriter = new FileWriter(file);
			CSVWriter writer = new CSVWriter(fileWriter);
			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] {"nome","ultimonome","email","sexo","ipacesso","idade","nascimento"});
			for(Usuario usuario: usuarios) {
				data.add(new String[] {usuario.getNome(),usuario.getUltimonome(), usuario.getEmail(),usuario.getSexo(),usuario.getIpacesso(), usuario.getNascimento()});
			}
			writer.writeAll(data);
			writer.close();
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public ByteArrayInputStream load() {
	    List<Usuario> tutorials = repository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
	    return in;
	  } 
	/*
	public boolean createCSV(List<Usuario> usuarios, ServletRequestContext context ) {
		
		return repository.createCSV(usuarios, context);
	
	} */
	
	
	
	
	public void filedownload(String fullPath, HttpServletResponse response, String fileName) {
		File file = new File(fullPath);
		final int BUFFER_SIZE = 4096;
		if(file.exists()) {
				if(file.exists()) {
					try {
						FileInputStream inputStream = new FileInputStream(file);
						String mimeType = context.getMimeType(fullPath);
						response.setContentType(mimeType);
						response.setHeader("content-disposition","attachment; filename="+ fileName);
						OutputStream outputStream = response.getOutputStream();
						byte[] buffer = new byte[BUFFER_SIZE];
						int bytesRead = -1;
						while((bytesRead = inputStream.read(buffer))!= -1) {
							outputStream.write(buffer, 0, bytesRead);
						}
						inputStream.close();
						outputStream.close();
						file.delete();
						
					}catch( Exception e) {
						e.printStackTrace();
					}
				}
			}
		
	
	
	
	}
}
