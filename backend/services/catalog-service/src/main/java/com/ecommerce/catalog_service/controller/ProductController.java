package com.ecommerce.catalog_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.catalog_service.dto.ProductDetailDTO;
import com.ecommerce.catalog_service.dto.ProductListDTO;
import com.ecommerce.catalog_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get products by category (PLP)
    @GetMapping("/category/{categoryId}")
    public Page<ProductListDTO> getProductsByCategory(
            @PathVariable UUID categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return productService.getProductsByCategory(
                categoryId,
                page,
                size,
                sortBy,
                direction);
    }

    // Get product detail (PDP)
    @GetMapping("/{slug}")
    public ProductDetailDTO getProduct(
            @PathVariable String slug) {

        return productService.getProductBySlug(slug);
    }

    // Search products (global search)
    @GetMapping("/search")
    public Page<ProductListDTO> searchProducts(
            @RequestParam String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return productService.searchProducts(q, page, size);
    }
}