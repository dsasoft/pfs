package br.com.dsasoft.pfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dsasoft.pfs.model.AccessObject;
@Entity
@Table(name="tb_access_obj")
public class AccessObjectEntity implements AccessObject {

	@Id
//	TODO: @Unique How to do it
	private Long identifier;
	@Column
	private String keyPass;
	@Column
	private String recoverKeyPassEmail;

	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKeyPass() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRecoverKeyPassEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getIdentifier(String identifier) {
		// TODO Auto-generated method stub
		
	}

	public void getKeyPass(String keyPass) {
		// TODO Auto-generated method stub
		
	}

	public void getRecoverKeyPassEmail(String recoverKeyPassEmail) {
		// TODO Auto-generated method stub
		
	}

}
