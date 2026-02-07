package com.ecommerce.catalog_service.dto;


import java.util.List;
import java.util.UUID;

public class CategoryDetailsDto {

    private UUID id;
    private String name;
    private String slug;
    private String description;
    private boolean hasChildren;
    private List<BrowseSubCategoryDto> children;

    public CategoryDetailsDto(
            UUID id,
            String name,
            String slug,
            String description,
            boolean hasChildren,
            List<BrowseSubCategoryDto> children) {

        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.hasChildren = hasChildren;
        this.children = children;
    }

    // getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getSlug() { return slug; }
    public String getDescription() { return description; }
    public boolean isHasChildren() { return hasChildren; }
    public List<BrowseSubCategoryDto> getChildren() { return children; }
}

