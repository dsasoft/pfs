package br.com.dsasoft.pfs.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dsasoft.pfs.model.Center;
import br.com.dsasoft.pfs.model.Operation;
@Entity
@Table(name="tb_operation")
public class OperationEntity implements Operation {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private CenterEntity center;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column
	private BigDecimal amount;
	
	@Column
	private String description;
	

	public Center getCenter() {
		return this.center;
	}

	public Date getDate() {
		return this.date;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
