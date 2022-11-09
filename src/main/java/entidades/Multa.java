package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the multa database table.
 * 
 */
@Entity
@NamedQuery(name="Multa.findAll", query="SELECT m FROM Multa m")
public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_multa")
	private Date dataMulta;

	private BigDecimal valor;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="veiculo")
	private Veiculo veiculoBean;

	public Multa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataMulta() {
		return this.dataMulta;
	}

	public void setDataMulta(Date dataMulta) {
		this.dataMulta = dataMulta;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Veiculo getVeiculoBean() {
		return this.veiculoBean;
	}

	public void setVeiculoBean(Veiculo veiculoBean) {
		this.veiculoBean = veiculoBean;
	}

}