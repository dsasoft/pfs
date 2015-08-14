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
		return this.id;
	}

	public String getToken() {
		return this.token;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Boolean setActive() {
		return active;
	}

	public AccessObject getAccessObject() {
		return accessObject;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setRegDate(Date date) {
		this.regDate = date;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAccessObject(AccessObject accessObject) {
		this.accessObject = (AccessObjectEntity) accessObject;
	}

}
