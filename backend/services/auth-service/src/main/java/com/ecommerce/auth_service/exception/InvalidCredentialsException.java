package com.ecommerce.auth_service.exception;

public class InvalidCredentialsException extends RuntimeException{
	public InvalidCredentialsException(String message) {
		super(message);
	}
}
