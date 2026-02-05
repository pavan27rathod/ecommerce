package com.ecommerce.catalog_service.repository;

import com.ecommerce.catalog_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    // Top-level categories (CLP home)
	List<Category> findByParentIdIsNullAndIsActiveTrueOrderByDisplayOrderAsc();

    // Child categories for any category page
    List<Category> findByParentIdAndIsActiveTrueOrderByDisplayOrderAsc(UUID parentId);

    // Resolve category via SEO slug
    Optional<Category> findBySlugAndIsActiveTrue(String slug);

    // Full navigation use-case (later cached)
    List<Category> findByIsActiveTrueOrderByDisplayOrderAsc();
}
