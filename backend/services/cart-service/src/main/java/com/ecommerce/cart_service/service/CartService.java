package com.ecommerce.cart_service.service;

import com.ecommerce.cart_service.dto.*;

public interface CartService {

    CartResponse addToCart(String userId, AddToCartRequest request);

    CartResponse updateCartItem(String userId, String productId, UpdateCartItemRequest request);

    CartResponse removeItem(String userId, String productId);

    CartResponse getCart(String userId);
}