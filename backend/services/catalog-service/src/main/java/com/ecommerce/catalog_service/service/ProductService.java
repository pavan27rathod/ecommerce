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
import com.ecommerce.catalog_service.event.ProductCreatedEvent;
import com.ecommerce.catalog_service.repository.ProductPriceBreakRepository;
import com.ecommerce.catalog_service.repository.ProductRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductPriceBreakRepository priceBreakRepository;
    private final KafkaProducerService kafkaProducerService;
    private final CategoryService categoryService;


    public ProductService(ProductRepository productRepository,
            ProductPriceBreakRepository priceBreakRepository,
            KafkaProducerService kafkaProducerService,
            CategoryService categoryService) {
		this.productRepository = productRepository;
		this.priceBreakRepository = priceBreakRepository;
		this.kafkaProducerService = kafkaProducerService;
		this.categoryService = categoryService;
	}


    // PLP
//    public List<ProductListDTO> getProductsByCategory(UUID categoryId) {
//        return productRepository.findByCategoryId(categoryId)
//                .stream()
//                .map(ProductListDTO::new)
//                .toList();
//    }
    @Cacheable(value = "productsByCategory",
            key = "#categoryId + '-' + #page + '-' + #size + '-' + #sortBy + '-' + #direction")
    public Page<ProductListDTO> getProductsByCategory(
            UUID categoryId,
            int page,
            int size,
            String sortBy,
            String direction) {

        System.out.println("DB HIT — fetching from database");
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productPage =
                productRepository.findByCategoryId(categoryId, pageable);

        return productPage.map(product -> mapToListDTO(product));
    }


    // PDP
    @Cacheable(value = "productBySlug", key = "#slug")
    public ProductDetailDTO getProductBySlug(String slug) {

        Product product = productRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println("DB HIT — fetching from database");

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
    @Cacheable(value = "productSearch", key = "#query + '-' + #page + '-' + #size")
    public Page<ProductListDTO> searchProducts(String query, int page, int size) {

        System.out.println("DB HIT — fetching from database");
        Pageable pageable = PageRequest.of(page, size);

        Page<Product> products =
                productRepository.searchProducts(query, pageable);

        return products.map(product -> new ProductListDTO(product));
    }
    
    @Cacheable(
    	    value = "category_products_all",
    	    key = "#categoryId + '_' + #page + '_' + #size"
    	)
    	public Page<ProductListDTO> getProductsByCategoryAndSubcategories(
    	        UUID categoryId,
    	        int page,
    	        int size) {

    	    Pageable pageable = PageRequest.of(page, size);

    	    List<UUID> categoryIds =
    	        categoryService.getAllSubcategoryIds(categoryId);

    	    categoryIds.add(categoryId);

    	    return productRepository
    	        .findByCategoryIdIn(categoryIds, pageable)
    	        .map(product -> mapToListDTO(product));
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
    
    @Transactional
    @CacheEvict(value = {
            "productSearch",
            "productBySlug",
            "productsByCategory"
    }, allEntries = true)
    public void updateProduct(Product product) {

        productRepository.save(product);

        System.out.println("Cache cleared for products");
    }
    
//    Product savedProduct = productRepository.save(product);
//
//    ProductCreatedEvent event =
//            new ProductCreatedEvent(
//                    savedProduct.getId(),
//                    savedProduct.getName(),
//                    savedProduct.getSlug()
//            );
//
//    kafkaProducerService.sendProductCreatedEvent(event);

    public void saveProduct(Product product) {
    	Product savedProduct = productRepository.save(product);

    	ProductCreatedEvent event =
    	        new ProductCreatedEvent(
    	                savedProduct.getId(),
    	                savedProduct.getName(),
    	                savedProduct.getSlug()
    	        );

    	kafkaProducerService.sendProductCreatedEvent(event);

    }

}
