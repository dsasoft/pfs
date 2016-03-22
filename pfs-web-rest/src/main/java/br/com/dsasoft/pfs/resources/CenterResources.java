package br.com.dsasoft.pfs.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dsasoft.pfs.entity.CenterEntity;
import br.com.dsasoft.pfs.facade.CenterFacade;
import br.com.dsasoft.pfs.model.Center;

@Controller
@RequestMapping("center")
public class CenterResources {

	protected CenterFacade facade;
	
	public CenterResources() {
		facade = new CenterFacade(null);
	}
	
	@RequestMapping( value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseBody
	public ResponseEntity<List<CenterEntity>> listCenter(){
		List<CenterEntity> list = facade.listAll();
		for(Center c : list)
			System.out.println(c);
		return new ResponseEntity<List<CenterEntity>>(list, HttpStatus.OK);
	}
}
