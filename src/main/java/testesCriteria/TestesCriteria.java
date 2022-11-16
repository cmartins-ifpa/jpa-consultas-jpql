package testesCriteria;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entidades.Automovel;
import entidades.Veiculo;

public class TestesCriteria {
	public static void main(String[] args) {
		// consulta1GenericaEntidadeObject();
		// consulta2EntidadeAutomovel();
		//  consulta3OrdenandoResultado();

		//  consulta4FiltroWhereMaiorQue();

		// consulta5FiltroWhereLike();
		// consulta6FiltroWhereBetween();

		// consulta7FiltroWhereIn();
		// consulta8FiltroWhereIsNull();
		// consulta9FiltroWhereCombinandoPredicados();
		// consulta10FiltroWhereCombinandoPredicadosLogicos();
		//  consulta11Ordenando2Campos() ;
		// consulta12Contagem();
		// consulta13Media();
		//  consulta14Update();
		//  consulta15Delete();
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
		System.out.printf("%-10s  %-12s %-12s %10s \n", "ID", "Marca", "Modelo", "Valor");
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
	public static void consulta4FiltroWhereMaiorQue() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);

		CriteriaQuery<Automovel> select = criteriaQuery.select(root)
				.where(criteriaBuilder.gt(root.get("valor"), 100000));

		TypedQuery<Automovel> typedQuery = getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();

		System.out.println("Selecina os registros com filtro");

		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo", "Valor");
		for (Automovel o : resultlist) {
			System.out.printf("%-4s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		}
		getEntityManager().close();
	}

	public static void consulta5FiltroWhereLike() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);

		CriteriaQuery<Automovel> select = criteriaQuery.select(root)
				.where(criteriaBuilder.like(root.get("modelo"), "%PIC%"));

		TypedQuery<Automovel> typedQuery = getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();

		System.out.println("Selecina os registros com filtro");

		System.out.printf("%-10s  %-12s %-12s \n", "ID", "Marca", "Modelo", "Valor");
		for (Automovel o : resultlist) {
			System.out.printf("%-4s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		}
		getEntityManager().close();
	}

	public static void consulta6FiltroWhereBetween() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);

		CriteriaQuery<Automovel> select = criteriaQuery.select(root)
				.where(criteriaBuilder.between(root.get("valor"), 70000, 250000));

		TypedQuery<Automovel> typedQuery = getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();

		System.out.println("Selecina os registros com filtro");

		System.out.printf("%-10s  %-12s %-22s %10s \n", "ID", "Marca", "Modelo", "Valor");
		for (Automovel o : resultlist) {
			System.out.printf("%-10s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		}
		getEntityManager().close();
	}

	public static void consulta7FiltroWhereIn() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);

		CriteriaQuery<Automovel> select = criteriaQuery.select(root).where(root.get("marca").in("VW", "FORD", "GM"));

		TypedQuery<Automovel> typedQuery = getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();

		System.out.println("Selecina os registros com filtro");

		System.out.printf("%-10s  %-12s %-22s %10s\n", "ID", "Marca", "Modelo", "Valor");
		for (Automovel o : resultlist) {
			System.out.printf("%-10s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		}
		getEntityManager().close();
	}

	public static void consulta8FiltroWhereIsNull() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = criteriaBuilder.createQuery(Veiculo.class);
		Root<Veiculo> root = criteriaQuery.from(Veiculo.class);

		CriteriaQuery<Veiculo> select = criteriaQuery.select(root)
				.where(criteriaBuilder.isNull(root.get("proprietario")));

		TypedQuery<Veiculo> typedQuery = getEntityManager().createQuery(select);
		List<Veiculo> resultlist = typedQuery.getResultList();

		System.out.println("Selecina os registros com filtro");

		System.out.printf("\n%-10s  %-12s %-22s %-10s\n", "ID Veic", "Marca", "Placa", "Multas");
		for (Veiculo o : resultlist) {
			System.out.printf("%-10s  %-12s %-22s %10s \n", o.getId(), o.getAutomovel().getMarca(), o.getPlaca(),
					o.getMultas().size());
		}
		getEntityManager().close();
	}

	public static void consulta9FiltroWhereCombinandoPredicados() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = criteriaBuilder.createQuery(Veiculo.class);
		Root<Veiculo> root = criteriaQuery.from(Veiculo.class);
		// combinando predicados (comparações)
		Predicate[] predicados = new Predicate[2];
		predicados[0] = criteriaBuilder.isNull(root.get("proprietario"));
		predicados[1] = criteriaBuilder.like(root.get("placa"), "A%");
		CriteriaQuery<Veiculo> select = criteriaQuery.select(root).where(predicados);

		TypedQuery<Veiculo> typedQuery = getEntityManager().createQuery(select);
		List<Veiculo> resultlist = typedQuery.getResultList();

		System.out.println("Selecina os registros com filtro");

		System.out.printf("\n%-10s  %-12s %-22s %-10s\n", "ID-Vei", "Marca", "Placa", "Multas");
		for (Veiculo o : resultlist) {
			System.out.printf("%-10s  %-12s %-22s %10s \n", o.getId(), o.getAutomovel().getMarca(), o.getPlaca(),
					o.getMultas().size());
		}
		getEntityManager().close();
	}

	public static void consulta10FiltroWhereCombinandoPredicadosLogicos() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = criteriaBuilder.createQuery(Veiculo.class);
		Root<Veiculo> root = criteriaQuery.from(Veiculo.class);

		// combinando predicados (comparações) com expressao logica
		Predicate maiorQueValor = criteriaBuilder.gt(root.get("automovel").get("valor"), 100000);
		Predicate placaVeiculo = criteriaBuilder.like(root.get("placa"), "A%");
		CriteriaQuery<Veiculo> select = criteriaQuery.select(root)
				.where(criteriaBuilder.or(maiorQueValor, placaVeiculo));

		TypedQuery<Veiculo> typedQuery = getEntityManager().createQuery(select);
		List<Veiculo> resultlist = typedQuery.getResultList();

		System.out.println("Selecina os registros com filtro");

		System.out.printf("\n%-10s  %-12s %-22s %-10s\n", "ID-Vei", "Marca", "Placa", "Valor Auto");
		for (Veiculo o : resultlist) {
			System.out.printf("%-10s  %-12s %-22s %10s \n", o.getId(), o.getAutomovel().getMarca(), o.getPlaca(),
					o.getAutomovel().getValor());
		}
		getEntityManager().close();
	}

	private static void consulta11Ordenando2Campos() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Automovel> criteriaQuery = criteriaBuilder.createQuery(Automovel.class);
		Root<Automovel> root = criteriaQuery.from(Automovel.class);
		CriteriaQuery<Automovel> select = criteriaQuery.select(root);

		select.orderBy(criteriaBuilder.asc(root.get("marca")), criteriaBuilder.desc(root.get("valor")));

		TypedQuery<Automovel> typedQuery = getEntityManager().createQuery(select);
		List<Automovel> resultlist = typedQuery.getResultList();

		System.out.println("Lista Ordenada por MARCA, VALOR (Desc)");
		System.out.printf("%-10s  %-12s %-12s %10s \n", "ID", "Marca", "Modelo", "Valor");
		for (Automovel o : resultlist) {
			System.out.printf("%-10s  %-12s %-22s %10s \n", o.getId(), o.getMarca(), o.getModelo(), o.getValor());
		}
		getEntityManager().close();
	}

	private static void consulta12Contagem() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<Long> cr = criteriaBuilder.createQuery(Long.class);
		Root<Automovel> root = cr.from(Automovel.class);
		cr.select(criteriaBuilder.count(root));
		TypedQuery<Long> query = getEntityManager().createQuery(cr);
		Long resultado = query.getSingleResult();

		System.out.printf("TOTAL DE LINHAS = %-10s \n", resultado);

		getEntityManager().close();
	}

	private static void consulta13Media() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<BigDecimal> cr = criteriaBuilder.createQuery(BigDecimal.class);
		Root<Automovel> root = cr.from(Automovel.class);

		cr.multiselect(criteriaBuilder.avg(root.get("valor")));
		TypedQuery<BigDecimal> query = getEntityManager().createQuery(cr);
		BigDecimal resultado = (BigDecimal) query.getSingleResult();

		System.out.printf("VALOR MÉDIO AUTOMOVEIS = %-10.2f \n", resultado);

		getEntityManager().close();
	}

	public static void consulta14Update() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Automovel> updateCriteria = cb.createCriteriaUpdate(Automovel.class);
		Root<Automovel> root = updateCriteria.from(Automovel.class);
		// atualiza dois campos da entidade 
		updateCriteria.set(root.get("valor"), new BigDecimal("99999"))
					  .set(root.get("modelo"), "FUSCA ATUAL");
		// configura a clausula where para localizar a chave primaria ID=2 
		updateCriteria.where(cb.equal(root.get("id"), 2));
		// efetiva o update na transacao
		int affected = em.createQuery(updateCriteria).executeUpdate();
		System.out.println("Linhas afetadas: " + affected);
		em.getTransaction().commit();
		 
	}

	public static void consulta15Delete() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaDelete<Automovel> criteriaDelete = cb.createCriteriaDelete(Automovel.class);
		Root<Automovel> root = criteriaDelete.from(Automovel.class);
		// filtra os veiculos acima de $200mil
		criteriaDelete.where(cb.greaterThan(root.get("valor"), 200000));

		// efetiva o update na transacao
		int affected = em.createQuery(criteriaDelete).executeUpdate();
		System.out.println("Linhas deletadas: " + affected); 
		em.getTransaction().commit();		 
	}
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
		EntityManager em = emf.createEntityManager();
		return em;
	}

}
