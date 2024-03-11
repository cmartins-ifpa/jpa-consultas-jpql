package exercicios;

import entidades.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Exercicio1Veiculos {

    public static void main(String[] args) {
     //   mostraTodosVeiculos();
        // mostraTodosVeiculosComProprietario();
        mostraTodosVeiculosComMulta();
    }

    private static void mostraTodosVeiculos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select a from Veiculo a", Veiculo.class);

        List<Veiculo> veiculos = q.getResultList();

        for (Veiculo v : veiculos) {
            System.out.println(
                    v.getProprietario() + " / "
                    + v.getAutomovel().getMarca() + " / "
                    + v.getPlaca() + " / "
                    + v.getDataCompra() + " / "
                    + v.getAtualProprietario()
            );
        }      // fim FOR 	

    } // fim metodo

    private static void mostraTodosVeiculosComProprietario() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select a from Veiculo a "
                + " where a.atualProprietario = true ", Veiculo.class);

        List<Veiculo> veiculos = q.getResultList();

        for (Veiculo v : veiculos) {
            System.out.println(
                    v.getProprietario() + " / "
                    + v.getAutomovel().getMarca() + " / "
                    + v.getPlaca() + " / "
                    + v.getDataCompra() + " / "
                    + v.getAtualProprietario()
            );
        }      // fim FOR 	

    } // fim metodo

    
    private static void mostraTodosVeiculosComMulta() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-consultas");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select a from Veiculo a "
                + " where SIZE(a.multas) >= 1   ", Veiculo.class);

        List<Veiculo> veiculos = q.getResultList();

        for (Veiculo v : veiculos) {
            System.out.println(
                    v.getProprietario() + " / "
                    + v.getAutomovel().getMarca() + " / "
                    + v.getPlaca() + " / "
                    + v.getDataCompra() + " / "
                    + v.getAtualProprietario() + " MULTAS = " 
                    + v.getMultas().size()
            );
        }      // fim FOR 	

    } // fim metodo
}
