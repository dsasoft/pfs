package br.com.dsasoft.pfs.facade;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class FacadeBase<T> {

	protected EntityManager em;
	
	protected FacadeBase(){ };
	
	@Deprecated
	public FacadeBase(EntityManager em){
		this.em = em;
	}
	
	public abstract T findById(Long id);
	
	public abstract List<T> listAll();
	
	public abstract void update( T t);
	
	public abstract void delete( T t);
	
	public abstract Long create( T t);
}
