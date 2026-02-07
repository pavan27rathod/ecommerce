package com.ecommerce.catalog_service.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.catalog_service.entity.ProductPriceBreak;

@Repository
public interface ProductPriceBreakRepository
        extends JpaRepository<ProductPriceBreak, UUID> {

    List<ProductPriceBreak> findByProductIdOrderByMinQuantityAsc(UUID productId);

}

