package br.com.dsasoft.pfs.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.dsasoft.pfs.facade.CenterFacade;
import br.com.dsasoft.pfs.model.Center;

@Path("/center")
public class CenterResouces {

	CenterFacade facade;
	
	public CenterResouces() {
		facade = new CenterFacade(null);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listCenter(){
		List<Center> list = facade.listAll();
		for(Center c : list)
			System.out.println(c);
		GenericEntity<List<Center>> entity = new GenericEntity<List<Center>>(list){};
		return Response.ok(entity).build();
	}
	
//	public Center 
}
