package br.com.dsasoft.pfs.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dsasoft.pfs.model.Account;
import br.com.dsasoft.pfs.model.Intransfer;
@Entity
@Table(name="tb_intransfer")
public class IntransferEntity implements Intransfer {

	@Column
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne
	private Account accountFrom;
	@OneToOne
	private Account accountTo;
	@Column
	private BigDecimal amount;
	
	public Date getDate() {
		return this.date;
	}

	public Account getAccountFrom() {
		return this.accountFrom;
	}

	public Account getAccountTo() {
		return this.accountTo;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

}
