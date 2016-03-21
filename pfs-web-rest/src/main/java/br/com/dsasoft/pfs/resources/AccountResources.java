package br.com.dsasoft.pfs.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public ResponseEntity<List<AccountEntity>> listAccount(){
		return new ResponseEntity<List<AccountEntity>>(facade.listAll(), HttpStatus.OK);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id){
		return new ResponseEntity<Account>(facade.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping( value = "/all/except/{id}", method = RequestMethod.GET, produces  = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AccountEntity>> listAccount(@PathVariable("id") Long id){
		AccountFacade facadeAccount = new AccountFacade(null);
		return new ResponseEntity<List<AccountEntity>>(facadeAccount.listAllExceptId(id), HttpStatus.OK);
	}
}
