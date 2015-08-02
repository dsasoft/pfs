package br.com.dsasoft.pfs;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		Map<String, String> pfsMap = new LinkedHashMap<String, String>();

		pfsMap.put(Persistence.PERSISTENCE_PROVIDER, "org.hibernate.ejb.HibernatePersistence");
		pfsMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		pfsMap.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/pfs_db");
		pfsMap.put("javax.persistence.jdbc.user", "root");
		pfsMap.put("javax.persistence.jdbc.password", "root");

		emf = Persistence.createEntityManagerFactory("pfs-entity");
//		emf = Persistence.createEntityManagerFactory("pfsMap", pfsMap);
	}
}
