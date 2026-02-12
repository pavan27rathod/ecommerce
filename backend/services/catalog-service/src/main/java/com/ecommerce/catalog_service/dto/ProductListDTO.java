package com.ecommerce.catalog_service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.ecommerce.catalog_service.entity.Product;

public class ProductListDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private UUID id;
    private String name;
    private String slug;
    private String manufacturer;
    private String manufacturerPartNumber;
    private String imageUrl;
    private BigDecimal price;
    private Integer stockQuantity;

    public ProductListDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.slug = product.getSlug();
        this.manufacturer = product.getManufacturer();
        this.manufacturerPartNumber = product.getManufacturerPartNumber();
        this.imageUrl = product.getImageUrl();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
    }
    
    public ProductListDTO(
            UUID id,
            String name,
            String slug,
            String manufacturer,
            String manufacturerPartNumber,
            BigDecimal price,
            String imageUrl,
            Integer stockQuantity
    ) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.manufacturer = manufacturer;
        this.manufacturerPartNumber = manufacturerPartNumber;
        this.price = price;
        this.imageUrl = imageUrl;
        this.stockQuantity = stockQuantity;
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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerPartNumber() {
		return manufacturerPartNumber;
	}

	public void setManufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
    
    
}
