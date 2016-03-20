package br.com.dsasoft.pfs.facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PfsEntityManagerFactory {

	static EntityManagerFactory emf;

	static EntityManager em;
	
	public static EntityManager getInstance(){
		emf = Persistence.createEntityManagerFactory("pfs-entity");
		em = emf.createEntityManager();
	
		return em;
	}
}
