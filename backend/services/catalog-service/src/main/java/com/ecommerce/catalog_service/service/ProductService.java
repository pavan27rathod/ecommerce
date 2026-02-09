package com.ecommerce.catalog_service.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecommerce.catalog_service.dto.ProductDetailDTO;
import com.ecommerce.catalog_service.dto.ProductListDTO;
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

    // PLP
//    public List<ProductListDTO> getProductsByCategory(UUID categoryId) {
//        return productRepository.findByCategoryId(categoryId)
//                .stream()
//                .map(ProductListDTO::new)
//                .toList();
//    }
    
    public Page<ProductListDTO> getProductsByCategory(
            UUID categoryId,
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productPage =
                productRepository.findByCategoryId(categoryId, pageable);

        return productPage.map(product -> mapToListDTO(product));
    }


    // PDP
    public ProductDetailDTO getProductBySlug(String slug) {

        Product product = productRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<ProductPriceBreak> priceBreaks =
                priceBreakRepository.findByProductIdOrderByMinQuantityAsc(product.getId());

        return mapToDetailDTO(product, priceBreaks);
    }

    // Search
//    public List<ProductListDTO> searchProducts(String query) {
//
//        return productRepository.searchProducts(query)
//                .stream()
//                .map(ProductListDTO::new)
//                .toList();
//    }
    
    public Page<ProductListDTO> searchProducts(String query, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> products =
                productRepository.searchProducts(query, pageable);

        return products.map(product -> new ProductListDTO(product));
    }


    private ProductDetailDTO mapToDetailDTO(Product product,
                                            List<ProductPriceBreak> priceBreaks) {

        return new ProductDetailDTO(
                product.getId(),
                product.getName(),
                product.getSlug(),
                product.getManufacturer(),
                product.getManufacturerPartNumber(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getImageUrl(),
                priceBreaks
        );
    }
    
    private ProductListDTO mapToListDTO(Product product) {

        return new ProductListDTO(
                product.getId(),
                product.getName(),
                product.getSlug(),
                product.getManufacturer(),
                product.getManufacturerPartNumber(),
                product.getPrice(),
                product.getImageUrl(),
                product.getStockQuantity()
        );
    }

}
