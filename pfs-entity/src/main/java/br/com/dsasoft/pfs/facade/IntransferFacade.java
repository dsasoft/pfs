package br.com.dsasoft.pfs.facade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dsasoft.pfs.entity.IntransferEntity;
import br.com.dsasoft.pfs.model.Intransfer;

public class IntransferFacade extends FacadeBase<Intransfer> {

	@PersistenceContext
	EntityManagerFactory emf;

	EntityManager em;

	public IntransferFacade(EntityManager em) {
		super(em);
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		this.em = emf.createEntityManager();
	}

	@Override
	public Intransfer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Intransfer> listAll() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT i FROM IntransferEntity i ");
		@SuppressWarnings("unchecked")
		List<IntransferEntity> list = query.getResultList();
		em.flush();
		em.getTransaction().commit();
		
		List<Intransfer> l = new ArrayList<Intransfer>();
				
		for(Intransfer i : list)
			l.add(i);
		
		return l;
	}

	@Override
	public void update(Intransfer t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Intransfer t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long create(Intransfer t) {
		em.getTransaction().begin();
		em.persist(t);
		em.flush();
		em.getTransaction().commit();
		return t.getId();
	}

}
