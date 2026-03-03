package com.ecommerce.cart_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddToCartRequest {

    @NotBlank(message = "Product ID must not be blank")
    private String productId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
}