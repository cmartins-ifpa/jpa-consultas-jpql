package testesJPQL;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Automovel;

public class TestesJPQL {
	public static void main(String[] args) {
		teste4ConsultaEstruturaComplexaComObjeto() ;
	}

	public static void teste1ConsultasSimples() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select a from Automovel a", Automovel.class);

		List<Automovel> autos = q.getResultList();

		for (Automovel auto : autos) {
			System.out.println(auto.getMarca() + " "
                                + auto.getModelo() 
                                + " " + auto.getAnomodelo());
		}

		// consulta de um objeto usando o campo AnoFabricacao
		int anoFab = 2022;
		Query q2 = em.createQuery("select a from Automovel a " + 
                          " where a.anofabricacao = " + anoFab, Automovel.class);

		List<Automovel> autosF = q2.getResultList();
		System.out.println("\nExibindo automoveis do anoFabricao = " + anoFab);
		for (Automovel a : autosF) {
			System.out.println(a.getMarca() + " " + a.getModelo() + " " +
                                 a.getAnofabricacao()+  "  - MODELO: "
                                 + a.getAnomodelo());
		}
	}

	public static void teste2ConsultaComParametros() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();

		// consulta de um objeto usando o campo AnoFabricacao como parametro
		int anoFab = 2022;
		Query q2 = em.createQuery("select a from Automovel a " + 
                        " where a.anofabricacao = :anofab", Automovel.class);
		q2.setParameter("anofab", anoFab);

		List<Automovel> autosF = q2.getResultList();
		System.out.println("\nExibindo automoveis do anoFabricao = " + anoFab);
		for (Automovel a : autosF) {
			System.out.println(a.getMarca() + " " + a.getModelo() + " " + a.getAnomodelo());
		}
	}

	public static void teste3ConsultaAgregacoes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();
		String jpql = "select AVG(a.valor) from Automovel a";
		Query query = em.createQuery(jpql, Double.class);
		Double media = (Double) query.getSingleResult();
		System.out.println("O valor médio dos automóveis é = " + media);
	}

	public static void teste4ConsultaEstruturaComplexa() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT v.dataCompra, v.placa, v.automovel.valor"
                        + " FROM Veiculo v";
		Query query = em.createQuery(jpql);
		List<Object[]> result = query.getResultList();
		for (Object[] row : result) {
			java.util.Date dataCompra = (java.util.Date) row[0];
			String placa = (String) row[1];
			BigDecimal valor = (BigDecimal) row[2];
			System.out.printf("%-10s  %-10s %12s \n", dataCompra, placa, valor);
		}

	}
	public static void teste4ConsultaEstruturaComplexaComObjeto() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT NEW testesJPQL.ResumoConsulta(v.dataCompra, v.placa, v.automovel.valor)"
				    + "  FROM Veiculo v";
		Query query = em.createQuery(jpql);
		List<ResumoConsulta> result = query.getResultList();
		for (ResumoConsulta row : result) {
			java.util.Date dataCompra = row.getDataCompra();
			String placa = row.getPlaca();
			BigDecimal valor = row.getValor();
			System.out.printf("%-10s  %-10s %12s \n", dataCompra, placa, valor);
		}

	}
}


