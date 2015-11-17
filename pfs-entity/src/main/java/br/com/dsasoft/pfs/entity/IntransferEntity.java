package br.com.dsasoft.pfs.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dsasoft.pfs.model.Intransfer;
@Entity
@Table(name="tb_intransfer")
@XmlRootElement
public class IntransferEntity implements Intransfer {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column
	private Long accountFrom;
	@Column
	private Long accountTo;
	@Column
	private BigDecimal amount;
	@Column
	private String description;
	
	public Long getId() {
		return this.id;
	}
	
	public Date getDate() {
		return this.date;
	}

	public Long getAccountFrom() {
		return this.accountFrom;
	}

	public Long getAccountTo() {
		return this.accountTo;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAccountFrom(Long idFrom) {
		this.accountFrom = idFrom;
	}

	public void setAccountTo(Long idTo) {
		this.accountTo = idTo;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
