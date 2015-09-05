package br.com.dsasoft.pfs.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dsasoft.pfs.entity.AccountEntity;

public class AccountFacade extends FacadeBase<AccountEntity> {

	@PersistenceContext
	EntityManagerFactory emf;

	EntityManager em;
	
	public AccountFacade(EntityManager em) {
		super(em);
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		this.em = emf.createEntityManager();
	}

	@Override
	public AccountEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountEntity> listAll() {
		Query query = 
				em.createQuery("SELECT a FROM AccountEntity AS a");
		
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
		// TODO Auto-generated method stub
		return null;
	}

	
}
