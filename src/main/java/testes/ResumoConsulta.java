package testes;

import java.math.BigDecimal;
import java.sql.Date;

public class ResumoConsulta {
	private String placa;
	private java.util.Date dataCompra;
	private BigDecimal valor;

	public ResumoConsulta(java.util.Date dataCompra, String placa, BigDecimal valor) {
		this.placa = placa;
		this.dataCompra = dataCompra;
		this.valor = valor;
	}

	// getters e setters se necessário
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public java.util.Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(java.util.Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
