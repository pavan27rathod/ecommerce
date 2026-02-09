package com.ecommerce.catalog_service.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.catalog_service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

	Optional<Product> findBySlug(String slug);

	 Page<Product> findByCategoryId(UUID categoryId, Pageable pageable);

    @Query("""
    		SELECT p FROM Product p
    		WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))
    		   OR LOWER(p.slug) LIKE LOWER(CONCAT('%', :query, '%'))
    		   OR LOWER(p.manufacturer) LIKE LOWER(CONCAT('%', :query, '%'))
    		   OR LOWER(p.manufacturerPartNumber) LIKE LOWER(CONCAT('%', :query, '%'))
    		""")
		    Page<Product> searchProducts(
		            @Param("query") String query,
		            Pageable pageable
		    );


}
