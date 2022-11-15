package testesCriteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entidades.Automovel;

public class TestesCriteria {
	public static void main(String[] args) {
		// consulta1GenericaEntidadeObject();
		  consulta2EntidadeAutomovel(); 
		consulta3OrdenandoResultado();
	}

	private static void consulta1GenericaEntidadeObject() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Automovel> from = criteriaQuery.from(Automovel.class);

		System.out.println("Selecina todos os registros");
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();
		
		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo"); 
		for (Object o : resultlist) {
			Automovel e = (Automovel) o;
			System.out.printf("%-10s  %-12s %-12s \n", e.getId(), e.getMarca(), e.getModelo());
		}
		em.close();
		emf.close();
	}

	
	private static void consulta2EntidadeAutomovel() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> from = criteriaQuery.from(Automovel.class);

		System.out.println("Selecina todos os registros");
		CriteriaQuery<Automovel> select = criteriaQuery.select(from);
		TypedQuery<Automovel> typedQuery = em.createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();
		
		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo"); 
		for (Automovel o : resultlist) {
			System.out.printf("%-10s  %-12s %-12s \n", o.getId(), o.getMarca(), o.getModelo());
		}
		em.close();
		emf.close();
	}
	


	private static void consulta3OrdenandoResultado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> from = criteriaQuery.from(Automovel.class);

		System.out.println("Selecina todos os registros");
		CriteriaQuery<Automovel> select = criteriaQuery.select(from);
		
		select.orderBy(criteriaBuilder.asc(from.get("marca")));
		 
		TypedQuery<Automovel> typedQuery = em.createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();
		
		System.out.println("Lista Ordenada por MARCA");
		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo"); 
		for (Automovel o : resultlist) {
			System.out.printf("%-10s  %-12s %-12s \n", o.getId(), o.getMarca(), o.getModelo());
		}
		em.close();
		emf.close();
	}


}
