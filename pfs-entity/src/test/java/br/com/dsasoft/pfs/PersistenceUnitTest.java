package br.com.dsasoft.pfs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnitTest {

	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pfs-entity");

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
	}
}
