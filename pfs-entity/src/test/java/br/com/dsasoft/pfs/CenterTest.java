package br.com.dsasoft.pfs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.dsasoft.pfs.entity.CenterEntity;
import br.com.dsasoft.pfs.model.Center;
import br.com.dsasoft.pfs.model.CenterType;

@RunWith(JUnit4.class)
public class CenterTest {

	@PersistenceContext
	EntityManagerFactory emf;

	EntityManager em;
	
	@Before
	public void givenPersistentContext() {
		System.out.println("\n\n[...] " + CenterTest.class.getName());
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		em = emf.createEntityManager();
	}
	
	@Test
	public void insert(){
		CenterEntity c = new CenterEntity();
		
		c.setName("transport");
		c.setCenterType(CenterType.OUTCOME);
		
		em.getTransaction().begin();
		
		em.persist(c);
		
		em.getTransaction().commit();
	}
	
	
	@Test
	public void select() {
		
		Query query = em.createQuery("select a from CenterEntity a");
		
		@SuppressWarnings("unchecked")
		List<Center> list = (List<Center>)	query.getResultList();
		
		for(Center c : list)
			System.out.println(c);
	}

}
