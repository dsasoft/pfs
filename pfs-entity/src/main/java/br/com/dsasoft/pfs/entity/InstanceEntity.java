package br.com.dsasoft.pfs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dsasoft.pfs.model.AccessObject;
import br.com.dsasoft.pfs.model.Instance;

@Entity
@Table(name="tb_instance")
public class InstanceEntity implements Instance {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String token;
	@Column
	@Temporal(TemporalType.DATE)
	private Date regDate;
	@Column
	private Boolean active;
	@OneToOne
	private AccessObjectEntity accessObject;

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getToken() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getRegDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean setActive() {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessObject getAccessObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public void setToken(String token) {
		// TODO Auto-generated method stub

	}

	public void setRegDate(Date date) {
		// TODO Auto-generated method stub

	}

	public void setActive(Boolean active) {
		// TODO Auto-generated method stub

	}

	public void setAccessObject(AccessObject accessObject) {
		// TODO Auto-generated method stub

	}

}
