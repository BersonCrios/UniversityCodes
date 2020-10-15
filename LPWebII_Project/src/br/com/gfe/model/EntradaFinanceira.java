package br.com.gfe.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unitins.frame.model.Model;


@Entity 
public class EntradaFinanceira extends Model<EntradaFinanceira>{

	private static final long serialVersionUID = -807767346483999390L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidEntradaFinanceira")
	@SequenceGenerator(name = "seqidEntradaFinanceira", sequenceName = "seqidEntradaFinanceira", allocationSize = 1)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private Double valor;
	
	private TipoRecurso recurso;
	
	@OneToOne
	@JoinColumn(name = "idMembro", nullable = false)
	private Membro membro;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoRecurso getRecurso() {
		return recurso;
	}

	public void setRecurso(TipoRecurso recurso) {
		this.recurso = recurso;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}
	
	public String getDataFormatada() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getData());
	}

}
