package br.com.gfe.model;

public enum Permissao {
	ROLE_ADMIN ("Administrador"),	
	ROLE_CONSELHO ("Conselho");
	
	private String nome;
	
	private Permissao(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	
}
