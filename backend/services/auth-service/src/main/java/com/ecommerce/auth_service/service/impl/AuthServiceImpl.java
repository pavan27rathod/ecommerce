package com.ecommerce.auth_service.service.impl;

import com.ecommerce.auth_service.dto.request.LoginRequest;
import com.ecommerce.auth_service.dto.request.RegisterRequest;
import com.ecommerce.auth_service.entity.User;
import com.ecommerce.auth_service.exception.InvalidCredentialsException;
import com.ecommerce.auth_service.exception.UserAlreadyExistsException;
import com.ecommerce.auth_service.repository.UserRepository;
import com.ecommerce.auth_service.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(
                "User already exists with email: " + request.getEmail()
            );
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setTitle(request.getTitle());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setMobileNumber(request.getMobileNumber());
        user.setCompanyName(request.getCompanyName());
        user.setGstNumber(request.getGstNumber());
        user.setJobRole(request.getJobRole());
        user.setPrimaryUse(request.getPrimaryUse());
        user.setContactEmail(request.getContactEmail());
        user.setContactPhone(request.getContactPhone());
        user.setContactSms(request.getContactSms());
        user.setRememberMe(request.getRememberMe());

        userRepository.save(user);
    }
    
    public void login(LoginRequest request) {

        if (request.getEmail() == null || request.getPassword() == null) {
            throw new InvalidCredentialsException("Email or password missing");
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Invalid email or password")
                );

        if (!request.getPassword().equals(user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }

}
