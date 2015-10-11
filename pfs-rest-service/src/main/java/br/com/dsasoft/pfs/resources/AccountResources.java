package br.com.dsasoft.pfs.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dsasoft.pfs.entity.AccountEntity;
import br.com.dsasoft.pfs.facade.AccountFacade;
import br.com.dsasoft.pfs.facade.FacadeBase;
import br.com.dsasoft.pfs.model.Account;

@Path("account")
public class AccountResources {

	FacadeBase<AccountEntity> facade;
	
	public AccountResources(){
		facade = new AccountFacade(null);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccountEntity> listAccount(){
		return facade.listAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("id") Long id){
		return facade.findById(id);
	}
}
