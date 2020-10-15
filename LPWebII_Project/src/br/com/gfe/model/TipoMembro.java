package br.com.gfe.model;

public enum TipoMembro {
	COMUNGANTE (0, "Comungante"),	
	NAO_COMUNGANTE (1, "Não Comungante");
	
	
	private Integer valor;
	private String nome;
	
	private TipoMembro(Integer valor, String nome){
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
