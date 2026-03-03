package com.ecommerce.cart_service.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartItemResponse {

    private String productId;

    private String productName;

    private String orderCode;

    private String manufacturer;

    private String imageUrl;

    private BigDecimal price;

    private Integer quantity;

    private BigDecimal lineTotal;
}