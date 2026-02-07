package com.ecommerce.catalog_service.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.catalog_service.entity.Product;
import com.ecommerce.catalog_service.entity.ProductPriceBreak;
import com.ecommerce.catalog_service.repository.ProductPriceBreakRepository;
import com.ecommerce.catalog_service.repository.ProductRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductPriceBreakRepository priceBreakRepository;

    public ProductService(ProductRepository productRepository,
                          ProductPriceBreakRepository priceBreakRepository) {
        this.productRepository = productRepository;
        this.priceBreakRepository = priceBreakRepository;
    }

    public List<Product> getProductsByCategory(UUID categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Optional<Product> getProductBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    public List<ProductPriceBreak> getPriceBreaks(UUID productId) {
        return priceBreakRepository
                .findByProductIdOrderByMinQuantityAsc(productId);
    }
}

