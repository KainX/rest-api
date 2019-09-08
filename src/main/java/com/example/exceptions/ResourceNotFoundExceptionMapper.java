package com.example.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.models.ErrorMessage;

/**
 * Mapper class for the ResourceNotFoundException class 
 * @author Kain
 *
 */
@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException>{

	@Override
	public Response toResponse(ResourceNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage error = new ErrorMessage(exception.getMessage(), 404, "www.google.com");
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
