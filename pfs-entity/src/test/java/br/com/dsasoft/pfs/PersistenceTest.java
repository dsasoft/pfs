package br.com.dsasoft.pfs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.dsasoft.pfs.model.Account;

@RunWith(JUnit4.class)
public class PersistenceTest {
	
	@PersistenceContext
	EntityManagerFactory emf;

	@Test
	public void helloJunit() {
		System.out.println("\n\n\n \tHello JUnit \n\n\n");
	}

	@Test
	public void persistenceContext() {
//		Map<String, String> pfsMap = new LinkedHashMap<String, String>();
//
//		pfsMap.put(Persistence.PERSISTENCE_PROVIDER, "org.hibernate.ejb.HibernatePersistence");
//		pfsMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
//		pfsMap.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/pfs_db");
//		pfsMap.put("javax.persistence.jdbc.user", "root");
//		pfsMap.put("javax.persistence.jdbc.password", "root");

		emf = Persistence.createEntityManagerFactory("pfs-entity");
		
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin();

		Query query = em.createQuery("select a from AccountEntity a");

		@SuppressWarnings("unchecked")
		List<Account> accounts = (List<Account>) query.getResultList();

		for (Account a : accounts)
			System.out.println(a);

//		em.getTransaction().commit();
		
	}
}
