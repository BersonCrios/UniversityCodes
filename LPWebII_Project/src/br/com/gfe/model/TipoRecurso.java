package br.com.gfe.model;

public enum TipoRecurso {
	DIZIMO (0, "Dizimo"),	
	OFERTA_GERAL (1, "Oferta Geral"),
	OFERTA_ESPECIFICA (2, "Oferta Especifica");
	
	private Integer valor;
	private String nome;
	
	private TipoRecurso(Integer valor, String nome){
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
 