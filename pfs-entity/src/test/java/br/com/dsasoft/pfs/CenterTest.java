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
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		em = emf.createEntityManager();
		
		insert();
	}
	
	private void insert(){
		CenterEntity cOut = new CenterEntity();
		
		cOut.setName("transport");
		cOut.setCenterType(CenterType.OUTCOME);
		
		Center cIn = new CenterEntity();
		cIn.setName("salary");
		cIn.setCenterType(CenterType.INCOME);
		
		em.getTransaction().begin();

//		em.merge(cIn);
//		em.merge(cOut);
		
		em.getTransaction().commit();
	}
	
	
	@Test
	public void select() {
		
		Query query = em.createQuery("SELECT c FROM CenterEntity AS c");
		
		
		@SuppressWarnings("unchecked")
		List<Center> list = (List<Center>)	query.getResultList();
		
		for(Center c : list)
			System.out.println(c);
	}

}
