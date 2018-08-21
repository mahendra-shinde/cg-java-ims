package com.mahendra;

import java.io.Serializable;

import javax.persistence.*;

public class Country implements Serializable {

	private String code;
	
	private String name;
	
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
