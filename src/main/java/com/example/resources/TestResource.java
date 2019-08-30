package com.example.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_PLAIN)
@Path("test")
public class TestResource {

	@GET
	public String getMessage(@MatrixParam("param1")String param1, @HeaderParam("param2")String param2,
							 @CookieParam("param3")String param3) {
		return "Matrix param: " + param1
				+ " Header param: " + param2
				+ " Cookie param: " + param3;
	}
	
}
