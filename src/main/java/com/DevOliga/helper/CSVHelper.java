package com.DevOliga.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;

import org.springframework.web.multipart.MultipartFile;

import com.DevOliga.model.Usuario;



public class CSVHelper {
	  public static String TYPE = "text/csv";
	  static String[] HEADERs = { "Nome", "UltimoNome", "Email", "Sexo", "IpAcesso", "Idade", "Nascimento" };

	  public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	
	 
	  public static List<Usuario> csvToTutorials(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	        		CSVFormat.DEFAULT.withHeader(HEADERs));) {

	      List<Usuario> usuarios = new ArrayList<Usuario>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      
	     
	
	      
	      for (CSVRecord csvRecord : csvRecords) {
	    	  Usuario usuario = new Usuario(
	    
	              csvRecord.get("Nome"),
	              csvRecord.get("UltimoNome"),
	              csvRecord.get("Email"),
	              csvRecord.get("Sexo"),
	              csvRecord.get("IpAcesso"),
	              Integer.parseInt(csvRecord.get("Idade")),
	              csvRecord.get("Nascimento")
	             
	            );

	        usuarios.add(usuario);
	      }

	      return usuarios;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }

	  public static ByteArrayInputStream tutorialsToCSV(List<Usuario> usuarios) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (Usuario usuario : usuarios) {
	        List<String> data = Arrays.asList(
	        		usuario.getNome(),
	        		usuario.getUltimonome(),
	        		usuario.getEmail(),
	        		usuario.getSexo(),
	        		usuario.getIpacesso(),
	        		String.valueOf(usuario.getIdade()),
	        		usuario.getNascimento()
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }

	}
