package br.com.dsasoft.pfs.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dsasoft.pfs.entity.OperationEntity;
import br.com.dsasoft.pfs.facade.OperationFacade;

@Controller
@RequestMapping("operation")
public class OperationResources {

	protected OperationFacade facade;
	
	@RequestMapping( value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseBody
	public ResponseEntity<List<OperationEntity>> list(){
		List<OperationEntity> list = facade.listAll();
		return new ResponseEntity<List<OperationEntity>>(list, HttpStatus.OK);
	}
}
