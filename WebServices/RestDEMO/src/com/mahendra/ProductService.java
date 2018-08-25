package com.mahendra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/products")
public class ProductService {
	
	@GET
	@Path("/find-{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String find(@PathParam("id") int id) {
		return "product "+id;
	}
}
