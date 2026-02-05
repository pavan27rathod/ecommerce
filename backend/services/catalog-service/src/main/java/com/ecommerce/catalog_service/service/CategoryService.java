package com.ecommerce.catalog_service.service;

import com.ecommerce.catalog_service.entity.Category;
import com.ecommerce.catalog_service.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor injection (required)
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * CLP Home: fetch active root categories
     */
    public List<Category> findActiveRootCategories() {
        return categoryRepository
                .findByParentIdIsNullAndIsActiveTrueOrderByDisplayOrderAsc();
    }

    /**
     * CLP/Sub-CLP: fetch active children for a given category
     */
    public List<Category> findActiveChildCategories(UUID parentId) {
        return categoryRepository
                .findByParentIdAndIsActiveTrueOrderByDisplayOrderAsc(parentId);
    }

    /**
     * Resolve category by SEO slug
     */
    public Optional<Category> findActiveCategoryBySlug(String slug) {
        return categoryRepository
                .findBySlugAndIsActiveTrue(slug);
    }

    /**
     * Navigation / cache warmup use
     */
    public List<Category> findAllActiveCategoriesSorted() {
        return categoryRepository
                .findByIsActiveTrueOrderByDisplayOrderAsc();
    }

    /**
     * UI decision helper:
     * If category has children -> show CLP
     * If no children -> allow direct PLP
     */
    public boolean hasActiveChildren(UUID categoryId) {
        return !findActiveChildCategories(categoryId).isEmpty();
    }
}
