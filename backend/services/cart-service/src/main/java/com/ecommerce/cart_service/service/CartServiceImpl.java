package com.ecommerce.cart_service.service;

import com.ecommerce.cart_service.dto.*;
import com.ecommerce.cart_service.entity.*;
import com.ecommerce.cart_service.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public CartResponse addToCart(String userId, AddToCartRequest request) {

        Cart cart = cartRepository
                .findByUserIdAndStatus(userId, CartStatus.ACTIVE)
                .orElseGet(() -> createNewCart(userId));

        Optional<CartItem> existingItem = cart.getItems()
                .stream()
                .filter(item -> item.getProductId().equals(request.getProductId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(
                    existingItem.get().getQuantity() + request.getQuantity()
            );
        } else {
            CartItem newItem = CartItem.builder()
                    .productId(request.getProductId())
                    .quantity(request.getQuantity())
                    .priceSnapshot(BigDecimal.ZERO) // temporary
                    .addedAt(Instant.now())
                    .build();

            cart.getItems().add(newItem);
        }

        cart.setUpdatedAt(Instant.now());
        cartRepository.save(cart);

        return mapToCartResponse(cart);
    }

    @Override
    public CartResponse updateCartItem(String userId, String productId, UpdateCartItemRequest request) {

        Cart cart = getActiveCart(userId);

        cart.getItems().removeIf(item -> {
            if (item.getProductId().equals(productId)) {
                if (request.getQuantity() <= 0) {
                    return true;
                }
                item.setQuantity(request.getQuantity());
            }
            return false;
        });

        cart.setUpdatedAt(Instant.now());
        cartRepository.save(cart);

        return mapToCartResponse(cart);
    }

    @Override
    public CartResponse removeItem(String userId, String productId) {

        Cart cart = getActiveCart(userId);

        cart.getItems().removeIf(item -> item.getProductId().equals(productId));

        cart.setUpdatedAt(Instant.now());
        cartRepository.save(cart);

        return mapToCartResponse(cart);
    }

    @Override
    public CartResponse getCart(String userId) {

        Cart cart = cartRepository
                .findByUserIdAndStatus(userId, CartStatus.ACTIVE)
                .orElseGet(() -> createNewCart(userId));

        return mapToCartResponse(cart);
    }

    // ----------------- PRIVATE METHODS -----------------

    private Cart createNewCart(String userId) {
        Cart cart = Cart.builder()
                .userId(userId)
                .status(CartStatus.ACTIVE)
                .items(new ArrayList<>())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        return cartRepository.save(cart);
    }

    private Cart getActiveCart(String userId) {
        return cartRepository
                .findByUserIdAndStatus(userId, CartStatus.ACTIVE)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    private CartResponse mapToCartResponse(Cart cart) {

        BigDecimal subTotal = BigDecimal.ZERO;
        int totalItems = 0;

        List<CartItemResponse> itemResponses = new ArrayList<>();

        for (var item : cart.getItems()) {

            BigDecimal lineTotal = item.getPriceSnapshot()
                    .multiply(BigDecimal.valueOf(item.getQuantity()));

            subTotal = subTotal.add(lineTotal);
            totalItems += item.getQuantity();

            itemResponses.add(
                    CartItemResponse.builder()
                            .productId(item.getProductId())
                            .productName(item.getProductName())
                            .orderCode(item.getOrderCode())
                            .manufacturer(item.getManufacturer())
                            .imageUrl(item.getImageUrl())
                            .price(item.getPriceSnapshot())
                            .quantity(item.getQuantity())
                            .lineTotal(lineTotal)
                            .build()
            );
        }

        return CartResponse.builder()
                .cartId(cart.getId())
                .userId(cart.getUserId())
                .items(itemResponses)
                .subTotal(subTotal)
                .totalItems(totalItems)
                .build();
    }
}