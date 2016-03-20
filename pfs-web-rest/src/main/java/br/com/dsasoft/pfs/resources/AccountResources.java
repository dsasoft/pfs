package br.com.dsasoft.pfs.resources;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dsasoft.pfs.entity.AccountEntity;
import br.com.dsasoft.pfs.facade.AccountFacade;
import br.com.dsasoft.pfs.facade.FacadeBase;
import br.com.dsasoft.pfs.model.Account;

@Controller
@RequestMapping("account")
public class AccountResources {

	FacadeBase<AccountEntity> facade;
	
	public AccountResources(){
		facade = new AccountFacade(null);
	}
	
	@RequestMapping( value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public List<AccountEntity> listAccount(){
		return facade.listAll();
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Account getAccount(@PathVariable("id") Long id){
		return facade.findById(id);
	}
	
	@RequestMapping( value = "/all/except/{id}", method = RequestMethod.GET, produces  = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<AccountEntity> listAccount(@PathVariable("id") Long id){
		AccountFacade facadeAccount = new AccountFacade(null);
		return facadeAccount.listAllExceptId(id);
	}
}
