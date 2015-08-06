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

import br.com.dsasoft.pfs.model.Intransfer;
@Entity
@Table(name="tb_intransfer")
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

}
