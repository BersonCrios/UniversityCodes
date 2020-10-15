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
public class SaidaFinanceira extends Model<SaidaFinanceira> {

	private static final long serialVersionUID = -4550010132127272647L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidSaidaFinanceira")
	@SequenceGenerator(name = "seqidSaidaFinanceira", sequenceName = "seqidSaidaFinanceira", allocationSize = 1)
	private Integer id;

	private String numeroDocumento;

	@Temporal(TemporalType.DATE)
	private Date dataDoDocumento;

	@Temporal(TemporalType.DATE)
	private Date dataOrdemDoPagamento;

	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	private Double valor;

	private TipoRecurso recurso;

	@OneToOne
	@JoinColumn(name = "idFornecedor", nullable = false)
	private Fornecedor fornecedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getDataDoDocumento() {
		return dataDoDocumento;
	}

	public void setDataDoDocumento(Date dataDoDocumento) {
		this.dataDoDocumento = dataDoDocumento;
	}

	public Date getDataOrdemDoPagamento() {
		return dataOrdemDoPagamento;
	}

	public void setDataOrdemDoPagamento(Date dataOrdemDoPagamento) {
		this.dataOrdemDoPagamento = dataOrdemDoPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public String getDataDocumentoFormatada() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getDataDoDocumento());
	}
	
	public String getDataOrdemPagamentoFormatada() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getDataOrdemDoPagamento());
	}
	
	public String getDataPagamentoFormatada() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getDataPagamento());
	}

}
