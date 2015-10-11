package br.com.dsasoft.pfs.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import br.com.dsasoft.pfs.entity.AccountEntity;
import br.com.dsasoft.pfs.entity.IntransferEntity;
import br.com.dsasoft.pfs.model.Account;
import br.com.dsasoft.pfs.model.Intransfer;

public class IntransferFacade extends FacadeBase<Intransfer> {

	@PersistenceUnit(unitName = "pfs-entity") 
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
		
		Intransfer i = (Intransfer)	em.find(AccountEntity.class, id);
		em.flush();
		return i;
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
		
		AccountFacade fAccount = new AccountFacade(em);
		
		Account from = fAccount.findById(t.getAccountFrom());
		Account to = fAccount.findById(t.getAccountTo());

		BigDecimal fBalanceFrom = from.getBalance().subtract(t.getAmount());
		BigDecimal fBalanceTo = to.getBalance().add(t.getAmount());
		
		from.setBalance(fBalanceFrom);
		to.setBalance(fBalanceTo);
		
		em.persist(t);
		em.flush();
		em.getTransaction().commit();
		return t.getId();
	}

}
