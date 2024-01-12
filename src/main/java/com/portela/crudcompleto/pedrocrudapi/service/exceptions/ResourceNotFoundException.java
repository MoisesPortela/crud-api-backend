package com.portela.crudcompleto.pedrocrudapi.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Drink não encontrado. Id "+ id +". Resource not found. Id "+ id);
	}

}
