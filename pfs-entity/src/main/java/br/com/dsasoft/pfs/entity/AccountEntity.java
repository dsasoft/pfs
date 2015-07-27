package br.com.dsasoft.pfs.entity;

import java.math.BigDecimal;

import br.com.dsasoft.pfs.model.Account;
//@Entity
//@Table(name="tb_account")
public class AccountEntity implements Account {

	//@Id
	//@Generated
	private Long id;
	//@Column(name="bame")
	private String name;
	//@Column(name="balance")
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
