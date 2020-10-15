package br.com.gfe.model;

public enum EstadoCivil {
	SOLTEIRO (0, "solteiro"),	
	CASADO (1, "casado"),
	VIUVO (2, "viuvo"),
	DIVORCIDAO (3, "divorciado");
	
	private Integer valor;
	private String nome;
	
	private EstadoCivil(Integer valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}
	
	public Integer getValor(){
		return valor;
	}
	
	public String getNome(){
		return nome;
	}
}
