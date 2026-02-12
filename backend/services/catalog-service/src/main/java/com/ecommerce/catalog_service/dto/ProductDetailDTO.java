package com.ecommerce.catalog_service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.ecommerce.catalog_service.entity.Product;
import com.ecommerce.catalog_service.entity.ProductPriceBreak;

//public class ProductDetailDTO {
//
//    private UUID id;
//    private String name;
//    private String slug;
//    private String manufacturer;
//    private String manufacturerPartNumber;
//    private String description;
//    private BigDecimal price;
//    private Integer stockQuantity;
//    private String imageUrl;
//
//    private List<ProductPriceBreakDTO> priceBreaks;
//
//    public ProductDetailDTO(Product product,
//                            List<ProductPriceBreak> breaks) {
//
//        this.id = product.getId();
//        this.name = product.getName();
//        this.slug = product.getSlug();
//        this.manufacturer = product.getManufacturer();
//        this.manufacturerPartNumber = product.getManufacturerPartNumber();
//        this.description = product.getDescription();
//        this.price = product.getPrice();
//        this.stockQuantity = product.getStockQuantity();
//        this.imageUrl = product.getImageUrl();
//
//        this.priceBreaks = breaks.stream()
//                .map(ProductPriceBreakDTO::new)
//                .toList();
//    }
//}
//

//package com.ecommerce.catalog_service.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.ecommerce.catalog_service.entity.ProductPriceBreak;

public class ProductDetailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private UUID id;
    private String name;
    private String slug;
    private String manufacturer;
    private String manufacturerPartNumber;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String imageUrl;
    private List<ProductPriceBreak> priceBreaks;

    public ProductDetailDTO(
            UUID id,
            String name,
            String slug,
            String manufacturer,
            String manufacturerPartNumber,
            String description,
            BigDecimal price,
            Integer stockQuantity,
            String imageUrl,
            List<ProductPriceBreak> priceBreaks
    ) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.manufacturer = manufacturer;
        this.manufacturerPartNumber = manufacturerPartNumber;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.priceBreaks = priceBreaks;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<ProductPriceBreak> getPriceBreaks() {
		return priceBreaks;
	}

	public void setPriceBreaks(List<ProductPriceBreak> priceBreaks) {
		this.priceBreaks = priceBreaks;
	}

    // getters
    
    
}

