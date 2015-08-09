package br.com.dsasoft.pfs.facade;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.dsasoft.pfs.model.Account;

public class AccountFacade extends FacadeBase<Account> {

	public AccountFacade(EntityManager em) {
		super(em);
	}

	@Override
	public Account findById(Long id) {
		return null;
	}

	@Override
	public List<Account> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long create(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

}
