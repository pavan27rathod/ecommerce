package com.ecommerce.auth_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiError {
    
	private String message;
    private int status;
    private LocalDateTime timestamp;
	public ApiError(String message, int status, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}
}

