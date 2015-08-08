package br.com.dsasoft.pfs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dsasoft.pfs.model.Instance;
import br.com.dsasoft.pfs.model.TokenLog;
@Entity
@Table(name="tb_token_log")
public class TokenLogEntity implements TokenLog {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String token;
	@Column
	@Temporal(TemporalType.DATE)
	private Date regDate;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiresDate;
	@Column
	private Long instanceId;
	
	
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getToken() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getExpiresDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Instance getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public void setToken(String token) {
		// TODO Auto-generated method stub

	}

	public void setCreatedDate(Date date) {
		// TODO Auto-generated method stub

	}

	public void setExpiresDate(Date date) {
		// TODO Auto-generated method stub

	}

	public void setInstance(Instance instance) {
		// TODO Auto-generated method stub

	}

}
