package br.com.dsasoft.pfs.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import br.com.dsasoft.pfs.entity.OperationEntity;

public class OperationFacade extends FacadeBase<OperationEntity> {

	@PersistenceUnit(unitName = "pfs-entity")
	EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;

	public OperationFacade(EntityManager em) {
		if (em != null && em.isOpen())
			this.em = em;
		else {
			emf = Persistence.createEntityManagerFactory("pfs-entity");
			this.em = emf.createEntityManager();
		}
	}

	@Override
	public OperationEntity findById(Long id) {
		return em.find(OperationEntity.class, id);
	}

	@Override
	public List<OperationEntity> listAll() {
		Query query = 
				em.createQuery("SELECT a FROM AccountEntity AS a");
		
		@SuppressWarnings("unchecked")
		List<OperationEntity> list = query.getResultList();
		
		return list;
	}

	@Override
	public void update(OperationEntity t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(OperationEntity t) {
		// TODO Auto-generated method stub
	}

	@Override
	public Long create(OperationEntity t) {
		em.getTransaction().begin();
		em.persist(t);
		em.flush();
		em.getTransaction().commit();
		return t.getId();
	}

}
