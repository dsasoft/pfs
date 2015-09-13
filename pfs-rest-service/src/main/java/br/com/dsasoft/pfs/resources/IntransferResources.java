package br.com.dsasoft.pfs.resources;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import br.com.dsasoft.pfs.entity.IntransferEntity;
import br.com.dsasoft.pfs.model.Intransfer;

@Path("intransfer")
public class IntransferResources {

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(value={"application/json; charset=UTF-8"})
	public Intransfer save(MultivaluedMap<String, String> form){
		
		Intransfer intransfer = new IntransferEntity();
		
		String strAmount = form.getFirst("it_amount");
		
		strAmount = strAmount.replace("R$ ", "");
		strAmount = strAmount.replace(",", ".");
		
		intransfer.setAccountFrom(new Long(form.getFirst("select-account-from")));
		intransfer.setAccountTo(new Long(form.getFirst("select-account-to")));
		intransfer.setAmount(new BigDecimal(strAmount));
		
		
		return intransfer;
	}
}