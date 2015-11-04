package br.com.dsasoft.pfs.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dsasoft.pfs.entity.CenterEntity;

public class CenterFacade extends FacadeBase<CenterEntity> {

	@PersistenceContext
	EntityManagerFactory emf;

	EntityManager em;
	
	public CenterFacade(EntityManager em) {
		super(em);
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		this.em = emf.createEntityManager();
	}

	@Override
	public CenterEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CenterEntity> listAll() {
		Query query = 
				em.createQuery("SELECT c FROM CenterEntity AS c");
		
		@SuppressWarnings("unchecked")
		List<CenterEntity> list = query.getResultList();		

		return list;
	}

	@Override
	public void update(CenterEntity t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CenterEntity t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long create(CenterEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

}
