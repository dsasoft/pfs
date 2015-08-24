package br.com.dsasoft.pfs.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id", "name", "centerType"})
public interface Center {

	public Long getId();
	
	public String getName();
		
	public CenterType getCenterType();
	
	public void setId(Long id);
	
	public void setName(String name);
	
	public void setCenterType(CenterType centerType);
}
