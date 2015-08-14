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
@Table(name = "tb_token_log")
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
	private Instance instance;

	public Long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public Date getCreatedDate() {
		return this.regDate;
	}

	public Date getExpiresDate() {
		return this.expiresDate;
	}

	public Instance getInstance() {
		return this.instance;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setCreatedDate(Date date) {
		this.regDate = date;
	}

	public void setExpiresDate(Date date) {
		this.expiresDate = date;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

}
