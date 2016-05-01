package br.com.dsasoft.pfs.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import br.com.dsasoft.pfs.entity.AccountEntity;

public class AccountFacade extends FacadeBase<AccountEntity> {

	@PersistenceUnit(unitName = "pfs-entity")
	EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;

	public AccountFacade(EntityManager em) {
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		this.em = emf.createEntityManager();
	}

	@Override
	public AccountEntity findById(Long id) {
		AccountEntity a = em.find(AccountEntity.class, id);
		return a;
	}

	@Override
	public List<AccountEntity> listAll() {
		Query query = em.createQuery("SELECT a FROM AccountEntity AS a");

		@SuppressWarnings("unchecked")
		List<AccountEntity> list = query.getResultList();
		return list;
	}

	public List<AccountEntity> listAllExceptId(Long id) {
		Query query = em
				.createQuery("SELECT a FROM AccountEntity AS a WHERE a.id NOT IN (:id) ");

		query.setParameter("id", id);

		@SuppressWarnings("unchecked")
		List<AccountEntity> list = query.getResultList();
		return list;
	}

	@Override
	public void update(AccountEntity t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(AccountEntity t) {
		// TODO Auto-generated method stub
	}

	@Override
	public Long create(AccountEntity t) {
		em.getTransaction().begin();
		em.persist(t);
		em.flush();
		em.getTransaction().commit();
		return t.getId();
	}
}
