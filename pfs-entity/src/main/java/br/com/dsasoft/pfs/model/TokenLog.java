package br.com.dsasoft.pfs.model;

import java.util.Date;

public interface TokenLog {

	public Long getId();

	public String getToken();

	public Date getCreatedDate();

	public Date getExpiresDate();

	public Instance getInstance();

	// --

	public void setId(Long id);

	public void setToken(String token);

	public void setCreatedDate(Date date);

	public void setExpiresDate(Date date);

	public void setInstance(Instance instance);

}
