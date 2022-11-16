package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="atual_proprietario")
	private Boolean atualProprietario;

	@Temporal(TemporalType.DATE)
	@Column(name="data_compra")
	private Date dataCompra;

	private String placa;

	private String proprietario;

	//bi-directional many-to-one association to Multa
	@OneToMany(mappedBy="veiculoBean")
	private List<Multa> multas;

	//bi-directional many-to-one association to Automovel
	@ManyToOne
	@JoinColumn(name="automovel")
	private Automovel automovel;

	public Veiculo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtualProprietario() {
		return this.atualProprietario;
	}

	public void setAtualProprietario(Boolean atualProprietario) {
		this.atualProprietario = atualProprietario;
	}

	public Date getDataCompra() {
		return this.dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public List<Multa> getMultas() {
		return this.multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public Multa addMulta(Multa multa) {
		getMultas().add(multa);
		multa.setVeiculoBean(this);

		return multa;
	}

	public Multa removeMulta(Multa multa) {
		getMultas().remove(multa);
		multa.setVeiculoBean(null);

		return multa;
	}

	public Automovel getAutomovel() {
		return this.automovel;
	}

	public void setAutomovel(Automovel automovelBean) {
		this.automovel = automovelBean;
	}

}