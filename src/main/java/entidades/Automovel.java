package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the automovel database table.
 * 
 */
@Entity
@NamedQuery(name="Automovel.findAll", query="SELECT a FROM Automovel a")
public class Automovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer anofabricacao;

	private Integer anomodelo;

	private String marca;

	private String modelo;

	private BigDecimal valor;

	//bi-directional many-to-one association to Veiculo
	@OneToMany(mappedBy="automovelBean")
	private List<Veiculo> veiculos;

	public Automovel() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnofabricacao() {
		return this.anofabricacao;
	}

	public void setAnofabricacao(Integer anofabricacao) {
		this.anofabricacao = anofabricacao;
	}

	public Integer getAnomodelo() {
		return this.anomodelo;
	}

	public void setAnomodelo(Integer anomodelo) {
		this.anomodelo = anomodelo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo addVeiculo(Veiculo veiculo) {
		getVeiculos().add(veiculo);
		veiculo.setAutomovelBean(this);

		return veiculo;
	}

	public Veiculo removeVeiculo(Veiculo veiculo) {
		getVeiculos().remove(veiculo);
		veiculo.setAutomovelBean(null);

		return veiculo;
	}

}