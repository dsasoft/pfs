package br.com.dsasoft.pfs.model;

import java.util.Date;

public interface Instance {
	
	public Long getId();
	
	public String getToken();
	
	public Date getRegDate();
	
	public Boolean setActive();
	
	public AccessObject getAccessObject();
	
	// --
	
	public void setId(Long id);
	
	public void setToken(String token);
	
	public void setRegDate(Date date);
	
	public void setActive(Boolean active);
	
	public void setAccessObject(AccessObject accessObject);

}
