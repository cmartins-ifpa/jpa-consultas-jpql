package testesCriteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import entidades.Automovel;
import entidades.Veiculo;

public class TestesCriteria {
	public static void main(String[] args) {
		// consulta1GenericaEntidadeObject();
		//consulta2EntidadeAutomovel(); 
		//consulta3OrdenandoResultado();
		
		// consulta4FiltroWhereMaiorQue();
	    
	    // consulta5FiltroWhereLike();
		consulta5FiltroWhereBetween();
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
		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo", "Valor"); 
		for (Automovel o : resultlist) {
			System.out.printf("%-4s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		}
		em.close();
		emf.close();
	}

	
	// Busca todos veiculos do tipo 1.8 E que a pessoa tenha nome Fernandes
    /**
     * 
     */
    public static void  consulta4FiltroWhereMaiorQue() {
    	CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();		 
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);

		CriteriaQuery<Automovel> select = criteriaQuery.select(root)
		      .where(criteriaBuilder.gt(root.get("valor"), 100000));
		
		TypedQuery<Automovel> typedQuery =  getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();
		
		System.out.println("Selecina os registros com filtro");
      
		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo", "Valor"); 
		for (Automovel o : resultlist) {
			System.out.printf("%-4s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		} 	
		getEntityManager().close();
    }

    public static void  consulta5FiltroWhereLike() {
    	CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();		 
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);

		CriteriaQuery<Automovel> select = criteriaQuery.select(root)
		      .where(criteriaBuilder.like(root.get("modelo"), "%PIC%"));
		
		TypedQuery<Automovel> typedQuery =  getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();
		
		System.out.println("Selecina os registros com filtro");
      
		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo", "Valor"); 
		for (Automovel o : resultlist) {
			System.out.printf("%-4s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		} 	
		getEntityManager().close();
    }
    
    public static void  consulta5FiltroWhereBetween() {
    	CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();		 
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);

		CriteriaQuery<Automovel> select = criteriaQuery.select(root)
		      .where(criteriaBuilder.between(root.get("valor"), 70000, 250000));
		
		TypedQuery<Automovel> typedQuery =  getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();
		
		System.out.println("Selecina os registros com filtro");
      
		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo", "Valor"); 
		for (Automovel o : resultlist) {
			System.out.printf("%-4s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		} 	
		getEntityManager().close();
    }
    public static EntityManager getEntityManager() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();
		return em;
    }
    
	 /**
	  * 
	  * findVeiculosByModeloAndNomePessoa
	  * 
	  * 	List lista = getSession().createCriteria(Veiculo.class)
			.add(Restrictions.like("modelo", modelo, MatchMode.ANYWHERE))
			.createAlias("pessoa", "p")
				.add(Restrictions.like("p.nome", nomePessoa, MatchMode.ANYWHERE))
			.list();
	  */

}
