package br.com.dsasoft.pfs.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dsasoft.pfs.model.Center;

public class CenterFacade extends FacadeBase<Center> {

	@PersistenceContext
	EntityManagerFactory emf;

	EntityManager em;
	
	public CenterFacade(EntityManager em) {
		super(em);
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		this.em = emf.createEntityManager();
	}

	@Override
	public Center findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Center> listAll() {
		Query query = 
				em.createQuery("SELECT c FROM CenterEntity AS c");
		
		@SuppressWarnings("unchecked")
		List<Center> list = query.getResultList();		

		return list;
	}

	@Override
	public void update(Center t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Center t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long create(Center t) {
		// TODO Auto-generated method stub
		return null;
	}

}
