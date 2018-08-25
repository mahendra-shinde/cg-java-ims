package com.mahendra;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private String name;
	private float price;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product(String name, float price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
