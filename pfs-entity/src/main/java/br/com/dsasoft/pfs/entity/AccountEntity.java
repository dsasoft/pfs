package br.com.dsasoft.pfs.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dsasoft.pfs.model.Account;
@Entity
@Table(name="tb_account")
@XmlRootElement
public class AccountEntity implements Account {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column(name="balance")
	private BigDecimal balance;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
