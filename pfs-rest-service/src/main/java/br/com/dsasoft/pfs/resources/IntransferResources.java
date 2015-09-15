package br.com.dsasoft.pfs.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.com.dsasoft.pfs.entity.IntransferEntity;
import br.com.dsasoft.pfs.facade.IntransferFacade;
import br.com.dsasoft.pfs.model.Intransfer;

@Path("intransfer")
public class IntransferResources {

	private IntransferFacade facade;
	
	public IntransferResources() {
		facade = new IntransferFacade(null);
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Intransfer> list(){
		return facade.listAll();
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(value={"application/json; charset=UTF-8"})
	public Intransfer save(MultivaluedMap<String, String> form){
		
		Intransfer intransfer = new IntransferEntity();
		
		String strAmount = form.getFirst("it_amount");
		
		strAmount = strAmount.replace("R$ ", "");
		strAmount = strAmount.replace(".", "");
		strAmount = strAmount.replace(",", ".");
		
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		DateTime dt = dtFormatter.parseDateTime(form.getFirst("it_datepicker"));
		
		intransfer.setAccountFrom(new Long(form.getFirst("select-account-from")));
		intransfer.setAccountTo(new Long(form.getFirst("select-account-to")));
		intransfer.setAmount(new BigDecimal(strAmount));
		intransfer.setDate(dt.toDate());
		
		Long id = facade.create(intransfer);
		
		intransfer.setId(id);
		
		return intransfer;
	}
}
