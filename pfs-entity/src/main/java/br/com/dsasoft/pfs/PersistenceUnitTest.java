package br.com.dsasoft.pfs;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//import org.junit.Test;

import br.com.dsasoft.pfs.model.Account;

public class PersistenceUnitTest {
	
	
//	@Test
	public static void main(String args[]) {
		
		Map<String, String> pfsMap = new LinkedHashMap<String, String>();
		
		pfsMap.put(Persistence.PERSISTENCE_PROVIDER, "org.hibernate.ejb.HibernatePersistence");
		pfsMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		pfsMap.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/pfs_db");
		pfsMap.put("java.persistence.jdbc.user", "root");
		pfsMap.put("javax.persistence.jdbc.password", "root");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pfsMap", pfsMap);

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Query query = em.createQuery("select a from Account a");

		@SuppressWarnings("unchecked")
		List<Account> accounts = (List<Account>) query.getResultList();

		for (Account a : accounts)
			System.out.println(a);

		em.getTransaction().commit();
	}
}
