package com.mahendra;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientRequest;
import org.glassfish.jersey.client.JerseyClientBuilder;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/save-product.do")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pprice = request.getParameter("price");
		String descr = request.getParameter("description");
		
		float price = Float.parseFloat(pprice);
		
		Product p = new Product(name, price, descr);
		
		Client client = JerseyClientBuilder.newClient();
		
		WebTarget target =	client.target("http://localhost:8080/RestDEMO/api/products/save");
		
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		 
		Response res = invocationBuilder.post(Entity.entity(p, MediaType.APPLICATION_JSON));
		
		response.getWriter().append("Product was added!: "+res.readEntity(String.class));
		
	}

}
