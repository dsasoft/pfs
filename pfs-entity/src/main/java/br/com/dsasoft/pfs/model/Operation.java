package br.com.dsasoft.pfs.model;

import java.math.BigDecimal;
import java.util.Date;

public interface Operation {

	public Center getCenter();
	
	public Date getDate();
	
	public BigDecimal getAmount();
	
	public String getDescription();
	
	public void setDescription(String desc);
	
	public void setAmount(BigDecimal bd);
	
	public void setDate(Date date);
	
	public void setCenter(Center center);
}
