package com.ecommerce.auth_service.service;

import com.ecommerce.auth_service.dto.request.LoginRequest;
import com.ecommerce.auth_service.dto.request.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    void login(LoginRequest request);
}
