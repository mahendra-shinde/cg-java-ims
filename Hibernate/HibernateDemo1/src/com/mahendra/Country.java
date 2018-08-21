package com.mahendra;

import java.io.Serializable;

import javax.persistence.*;


@Entity	//Denotes PERSISTANT CLASS
@Table(name="countries") //Denotes Tabled MAPPED to this class
public class Country implements Serializable {

	@Id
	@Column(name="country_id",length=2)
	private String code;
	
	@Column(name="country_name")
	private String name;
	
	@Column(name="region_id")
	private Integer regionId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
