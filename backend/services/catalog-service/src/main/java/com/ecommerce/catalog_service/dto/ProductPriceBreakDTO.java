package com.ecommerce.catalog_service.dto;

import java.math.BigDecimal;

import com.ecommerce.catalog_service.entity.ProductPriceBreak;

public class ProductPriceBreakDTO {

    private Integer minQuantity;
    private BigDecimal price;

    public ProductPriceBreakDTO(ProductPriceBreak pb) {
        this.minQuantity = pb.getMinQuantity();
        this.price = pb.getPrice();
    }
}

