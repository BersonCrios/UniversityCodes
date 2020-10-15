package br.com.gfe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unitins.frame.model.Model;

@Entity 
public class Caixa extends Model<Caixa>{

	private static final long serialVersionUID = -8054843423461972756L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidCaixa")
	@SequenceGenerator(name = "seqidCaixa", sequenceName = "seqidCaixa", allocationSize = 1)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	//@OneToMany(mappedBy ="caixa")
	private EntradaFinanceira entrada;
	
	//@OneToMany(mappedBy ="caixa")
	private SaidaFinanceira saida;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
