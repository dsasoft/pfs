package br.com.dsasoft.pfs.entity;

import br.com.dsasoft.pfs.model.Center;
import br.com.dsasoft.pfs.model.CenterType;
//@Entity
//@Table(name="tb_center")
public class CenterEntity implements Center {
	
	//@Id
	//@Generated
	private Long id;
	//@Column
	private String name;
	//TODO: how do we persist 'enum'
	//@Enum(type=EnumType.String)
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
