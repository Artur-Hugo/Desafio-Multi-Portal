package com.DevOliga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private String nome;
	private String ultimonome;
	private String email;
	private String sexo;
	
	private String ipacesso;
	
	private int idade;
	
	private String nascimento;
	
	public Usuario() {}

	public Usuario(String nome, String ultimonome, String email, String sexo, String ipacesso, int idade,
			String nascimento) {
		this.nome = nome;
		this.ultimonome = ultimonome;
		this.email = email;
		this.sexo = sexo;
		this.ipacesso = ipacesso;
		this.idade = idade;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimonome() {
		return ultimonome;
	}

	public void setUltimonome(String ultimonome) {
		this.ultimonome = ultimonome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIpacesso() {
		return ipacesso;
	}

	public void setIpacesso(String ipacesso) {
		this.ipacesso = ipacesso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	
	
}
