package br.com.dsasoft.pfs.model;

import java.math.BigDecimal;

public interface Account {

	public Long getId();
	
	public String getName();
	
	public BigDecimal getBalance();
	
	public void setId(Long id);
	
	public void setName(String name);
	
	public void setBalance(BigDecimal balance);
}
