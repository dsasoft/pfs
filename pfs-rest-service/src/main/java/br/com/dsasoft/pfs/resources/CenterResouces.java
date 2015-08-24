package br.com.dsasoft.pfs.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dsasoft.pfs.entity.CenterEntity;
import br.com.dsasoft.pfs.facade.CenterFacade;
import br.com.dsasoft.pfs.model.Center;
import br.com.dsasoft.pfs.model.CenterType;

@Path("/center")
public class CenterResouces {

	CenterFacade facade;
	
	public CenterResouces() {
		facade = new CenterFacade(null);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CenterEntity> listCenter(){
		List<CenterEntity> list = facade.listAll();
		for(Center c : list)
			System.out.println(c);
		return list;
	}
	
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public Center getCenter(){
		CenterEntity c = new CenterEntity();
		c.setCenterType(CenterType.INCOME);
		c.setName("salary");
		return c;
	}
}
