package br.com.dsasoft.pfs.model;

import java.math.BigDecimal;
import java.util.Date;

public interface Intransfer {

	public Date getDate();
	
	public Long getAccountFrom();
	
	public Long getAccountTo();
	
	public BigDecimal getAmount();
}
