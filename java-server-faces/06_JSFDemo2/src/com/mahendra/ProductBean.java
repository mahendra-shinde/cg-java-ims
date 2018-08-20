package com.mahendra;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ProductBean {
	private List<Product> products = new LinkedList<>();

	
	public ProductBean() {
		products.add(new Product(101, "Product A", 120.55F));
		products.add(new Product(102, "Product B", 67.5F));
		products.add(new Product(103, "Product C", 122.55F));
		products.add(new Product(104, "Product D", 188.8F));
		products.add(new Product(105, "Product E", 177.11F));
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
