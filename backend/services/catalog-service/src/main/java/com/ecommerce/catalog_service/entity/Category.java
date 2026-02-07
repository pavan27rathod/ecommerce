package com.ecommerce.catalog_service.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
    name = "category",
    indexes = {
        @Index(name = "idx_category_parent", columnList = "parent_id"),
        @Index(name = "idx_category_slug", columnList = "slug", unique = true),
        @Index(name = "idx_category_active", columnList = "is_active"),
        @Index(name = "idx_category_level", columnList = "level")
    }
)
@EntityListeners(AuditingEntityListener.class)
public class Category {

//    @Id
//    @GeneratedValue
//    @Column(columnDefinition = "uuid")
//    private UUID id;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(length = 36)
	private UUID id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 150, unique = true)
    private String slug;

    @Column(length = 1000)
    private String description;

//    @Column(name = "parent_id")
//    private UUID parentId;
    
    @Column(name = "parent_id", length = 36)
    private UUID parentId;


    @Column(nullable = false)
    private Integer level;

    @Column(name = "product_count", nullable = false)
    private Integer productCount = 0;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder = 0;

    @Column(name = "icon_url", length = 500)
    private String iconUrl;

    @Column(name = "seo_title", length = 255)
    private String seoTitle;

    @Column(name = "seo_description", length = 1000)
    private String seoDescription;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    // No-args constructor
    public Category() {
    }

    // All-args constructor
    public Category(UUID id, String name, String slug, String description, UUID parentId,
                    Integer level, Integer productCount, Boolean isActive, Integer displayOrder,
                    String iconUrl, String seoTitle, String seoDescription,
                    Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.parentId = parentId;
        this.level = level;
        this.productCount = productCount;
        this.isActive = isActive;
        this.displayOrder = displayOrder;
        this.iconUrl = iconUrl;
        this.seoTitle = seoTitle;
        this.seoDescription = seoDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Manual Builder
    public static class Builder {
        private UUID id;
        private String name;
        private String slug;
        private String description;
        private UUID parentId;
        private Integer level;
        private Integer productCount;
        private Boolean isActive;
        private Integer displayOrder;
        private String iconUrl;
        private String seoTitle;
        private String seoDescription;
        private Instant createdAt;
        private Instant updatedAt;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder slug(String slug) {
            this.slug = slug;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder parentId(UUID parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public Builder productCount(Integer productCount) {
            this.productCount = productCount;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder displayOrder(Integer displayOrder) {
            this.displayOrder = displayOrder;
            return this;
        }

        public Builder iconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public Builder seoTitle(String seoTitle) {
            this.seoTitle = seoTitle;
            return this;
        }

        public Builder seoDescription(String seoDescription) {
            this.seoDescription = seoDescription;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Category build() {
            return new Category(
                    id, name, slug, description, parentId,
                    level, productCount, isActive, displayOrder,
                    iconUrl, seoTitle, seoDescription,
                    createdAt, updatedAt
            );
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
