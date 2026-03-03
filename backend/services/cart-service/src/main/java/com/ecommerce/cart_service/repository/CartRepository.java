package com.ecommerce.cart_service.repository;

import com.ecommerce.cart_service.entity.Cart;
import com.ecommerce.cart_service.entity.CartStatus;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
    
    Optional<Cart> findByUserIdAndStatus(String userId, CartStatus status);
}