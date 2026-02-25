package com.ecommerce.cart_service.entity;

import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {

    private String productId;

    private String productName;

    private String orderCode;

    private String manufacturer;

    private String imageUrl;

    private BigDecimal priceSnapshot;

    private Integer quantity;

    private Integer minOrderQty;

    private Integer multipleOrderQty;

    private Instant addedAt;
}