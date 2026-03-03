package com.ecommerce.cart_service.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CartResponse {

    private String cartId;

    private String userId;

    private List<CartItemResponse> items;

    private BigDecimal subTotal;

    private Integer totalItems;
}