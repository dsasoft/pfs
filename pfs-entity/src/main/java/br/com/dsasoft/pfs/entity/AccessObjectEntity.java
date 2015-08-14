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
	private String identifier;
	@Column
	private String keyPass;
	@Column
	private String recoverKeyPassEmail;

	public String getIdentifier() {
		return this.identifier;
	}

	public String getKeyPass() {
		return this.keyPass;
	}

	public String getRecoverKeyPassEmail() {
		return this.recoverKeyPassEmail;
	}

	public void getIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void getKeyPass(String keyPass) {
		this.keyPass = keyPass;
	}

	public void getRecoverKeyPassEmail(String recoverKeyPassEmail) {
		this.recoverKeyPassEmail = recoverKeyPassEmail;
	}

}
