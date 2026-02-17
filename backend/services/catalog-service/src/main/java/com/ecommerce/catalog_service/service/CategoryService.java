package com.ecommerce.catalog_service.service;

import com.ecommerce.catalog_service.dto.BrowseCategoryDto;
import com.ecommerce.catalog_service.dto.BrowseSubCategoryDto;
import com.ecommerce.catalog_service.dto.CategoryDetailsDto;
import com.ecommerce.catalog_service.entity.Category;
import com.ecommerce.catalog_service.repository.CategoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findActiveRootCategories() {
        return categoryRepository
                .findByParentIdIsNullAndIsActiveTrueOrderByDisplayOrderAsc();
    }

    public List<Category> findActiveChildCategories(UUID parentId) {
        return categoryRepository
                .findByParentIdAndIsActiveTrueOrderByDisplayOrderAsc(parentId);
    }

    public Optional<Category> findActiveCategoryBySlug(String slug) {
        return categoryRepository
                .findBySlugAndIsActiveTrue(slug);
    }

    public List<Category> findAllActiveCategoriesSorted() {
        return categoryRepository
                .findByIsActiveTrueOrderByDisplayOrderAsc();
    }
    
    /**
     * NEW METHOD — used for PLP "View All Products"
     * Returns all subcategory IDs recursively
     * DOES NOT affect existing APIs
     */
    public List<UUID> getAllSubcategoryIds(UUID parentId) {

        List<Category> children =
                categoryRepository
                    .findByParentIdAndIsActiveTrueOrderByDisplayOrderAsc(parentId);

        List<UUID> ids = children.stream()
                .map(Category::getId)
                .collect(Collectors.toList());

        // recursive fetch
        for (Category child : children) {

            ids.addAll(getAllSubcategoryIds(child.getId()));

        }

        return ids;
    }


    public boolean hasActiveChildren(UUID categoryId) {
        return !findActiveChildCategories(categoryId).isEmpty();
    }

    /**
     * Browse page API logic
     */
    public List<BrowseCategoryDto> getBrowseCategories() {

        List<Category> rootCategories = findActiveRootCategories();

        return rootCategories.stream()
                .map(root -> {

                    List<BrowseSubCategoryDto> children =
                            findActiveChildCategories(root.getId())
                                    .stream()
                                    .map(child -> new BrowseSubCategoryDto(
                                            child.getId(),
                                            child.getName(),
                                            child.getSlug(),
                                            child.getProductCount()
                                    ))
                                    .collect(Collectors.toList());

                    return new BrowseCategoryDto(
                            root.getId(),
                            root.getName(),
                            root.getSlug(),
                            root.getProductCount(),
                            children
                    );

                })
                .collect(Collectors.toList());
    }
    
    public CategoryDetailsDto getCategoryDetails(String slug) {

        Category category = categoryRepository
                .findBySlugAndIsActiveTrue(slug)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        List<Category> childCategories =
                categoryRepository.findByParentIdAndIsActiveTrueOrderByDisplayOrderAsc(category.getId());

        List<BrowseSubCategoryDto> children =
                childCategories.stream()
                        .map(child -> new BrowseSubCategoryDto(
                                child.getId(),
                                child.getName(),
                                child.getSlug(),
                                child.getProductCount()
                        ))
                        .toList();

        boolean hasChildren = !children.isEmpty();

        return new CategoryDetailsDto(
                category.getId(),
                category.getName(),
                category.getSlug(),
                category.getDescription(),
                hasChildren,
                children
        );
    }

}
