package com.mahendra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/products")
public class ProductService {
	
	@GET
	@Path("/find-{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Product find(@PathParam("id") int id) {
		return new Product("Dell Inspiron 13", 68000, "Laptop");
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public String save(Product product) {
		return "Success";
	}
	//Add a method for POST
	//Set path to "save"
	//Use FormParam to accept the parameters
	//return string "Success"
}
///api/products/find-101