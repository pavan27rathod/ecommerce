package com.ecommerce.catalog_service.dto;

import java.util.List;
import java.util.UUID;

public class BrowseCategoryDto {

    private UUID id;
    private String name;
    private String slug;
    private int productCount;
    private List<BrowseSubCategoryDto> subCategories;

    public BrowseCategoryDto() {
    }

    public BrowseCategoryDto(UUID id,
                             String name,
                             String slug,
                             int productCount,
                             List<BrowseSubCategoryDto> subCategories) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.productCount = productCount;
        this.subCategories = subCategories;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public List<BrowseSubCategoryDto> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<BrowseSubCategoryDto> subCategories) {
        this.subCategories = subCategories;
    }
}
