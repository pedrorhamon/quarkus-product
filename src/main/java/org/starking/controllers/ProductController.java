package org.starking.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.starking.dtos.ProductDTO;
import org.starking.services.ProductService;

@Path("/api/product")
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> findAll() {
		return this.productService.findAll();
	}
	
	@POST
	@Transactional
	public Response save(ProductDTO dto) {
		try {
			this.productService.createNewProduct(dto);
			return Response.accepted().build();
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Transactional
	public Response changeProduct(@PathParam("id") Long id, ProductDTO dto) {
		try {
			this.productService.changeProduct(id, dto);
			return Response.accepted().build();
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public Response deleteProduct(@PathParam("id") Long id) {
		try {
			this.productService.deleteProduct(id);
			return Response.accepted().build();
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	

}
