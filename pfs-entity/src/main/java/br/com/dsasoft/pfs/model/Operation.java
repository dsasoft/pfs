package br.com.dsasoft.pfs.model;

import java.math.BigDecimal;
import java.util.Date;

public interface Operation {

	public Center getCenter();
	
	public Date getDate();
	
	public BigDecimal getAmount();
}
