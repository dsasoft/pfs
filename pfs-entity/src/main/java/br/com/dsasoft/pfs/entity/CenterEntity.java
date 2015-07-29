package br.com.dsasoft.pfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dsasoft.pfs.model.Center;
import br.com.dsasoft.pfs.model.CenterType;
@Entity
@Table(name="tb_center")
public class CenterEntity implements Center {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Enumerated(EnumType.STRING)
	private CenterType centerType;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CenterType getCenterType() {
		return centerType;
	}
}
