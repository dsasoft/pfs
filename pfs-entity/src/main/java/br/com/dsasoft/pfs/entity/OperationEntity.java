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
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dsasoft.pfs.model.Center;
import br.com.dsasoft.pfs.model.Operation;
@Entity
@Table(name="tb_operation")
@XmlRootElement
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

	@Override
	public Center getCenter() {
		return center;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String desc) {
		this.description = desc;		
	}

	@Override
	public void setAmount(BigDecimal bd) {
		this.amount = bd;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void setCenter(Center center) {
		this.center = (CenterEntity) center;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
		
}
