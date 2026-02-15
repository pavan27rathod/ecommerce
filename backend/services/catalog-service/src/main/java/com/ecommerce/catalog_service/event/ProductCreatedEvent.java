package com.ecommerce.catalog_service.event;

import java.util.UUID;

public class ProductCreatedEvent {

    private UUID productId;
    private String name;
    private String slug;

    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(UUID productId, String name, String slug) {
        this.productId = productId;
        this.name = name;
        this.slug = slug;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
