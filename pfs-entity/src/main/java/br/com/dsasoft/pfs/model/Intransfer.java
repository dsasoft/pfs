package br.com.dsasoft.pfs.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.dsasoft.pfs.entity.IntransferEntity;

@XmlRootElement
@XmlSeeAlso(value = { IntransferEntity.class })
public interface Intransfer {
	
	public Long getId();

	public Date getDate();
	
	public Long getAccountFrom();
	
	public Long getAccountTo();
	
	public BigDecimal getAmount();
	
	public void setId(Long id);
	
	public void setDate(Date date);
	
	public void setAccountFrom(Long idFrom);
	
	public void setAccountTo(Long idTo);
	
	public void setAmount(BigDecimal amount);
}
