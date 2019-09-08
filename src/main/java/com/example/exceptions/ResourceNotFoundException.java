package com.example.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1052526514146602011L;

	/**
	 * This constructor calls the superclass constructor 
	 * @param message A detailed message of the exception for later retrieval with getMessage()
	 */
	public ResourceNotFoundException(String message) {
		super(message); 
	}
	
}
