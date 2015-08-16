package br.com.dsasoft.pfs.model;

public interface Center {

	public Long getId();
	
	public String getName();
		
	public CenterType getCenterType();
	
	public void setId(Long id);
	
	public void setName(String name);
	
	public void setCenterType(CenterType centerType);
}
