package br.com.gfe.model;

public enum Ativo {
	ATIVO (0, "Ativo"),	
	NÃO_ATIVO (1, "Inativo");
	
	private Integer valor;
	private String nome;
	
	private Ativo(Integer valor, String nome){
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
