package com.ecommerce.cart_service.controller;

import com.ecommerce.cart_service.dto.*;
import com.ecommerce.cart_service.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 1️⃣ Add Product to Cart
    @PostMapping("/items")
    public CartResponse addToCart(
            @RequestHeader("X-USER-ID") String userId,
            @Valid @RequestBody AddToCartRequest request
    ) {
        return cartService.addToCart(userId, request);
    }

    // 2️⃣ Get Cart
    @GetMapping
    public CartResponse getCart(
            @RequestHeader("X-USER-ID") String userId
    ) {
        return cartService.getCart(userId);
    }

    // 3️⃣ Update Quantity
    @PutMapping("/items/{productId}")
    public CartResponse updateCartItem(
            @RequestHeader("X-USER-ID") String userId,
            @PathVariable String productId,
            @Valid @RequestBody UpdateCartItemRequest request
    ) {
        return cartService.updateCartItem(userId, productId, request);
    }

    // 4️⃣ Remove Item
    @DeleteMapping("/items/{productId}")
    public CartResponse removeItem(
            @RequestHeader("X-USER-ID") String userId,
            @PathVariable String productId
    ) {
        return cartService.removeItem(userId, productId);
    }
}