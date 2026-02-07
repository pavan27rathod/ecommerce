package com.ecommerce.catalog_service.controller;

import com.ecommerce.catalog_service.dto.BrowseCategoryDto;
import com.ecommerce.catalog_service.dto.BrowseSubCategoryDto;
import com.ecommerce.catalog_service.dto.CategoryDetailsDto;
import com.ecommerce.catalog_service.entity.Category;
import com.ecommerce.catalog_service.service.CategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/browse")
    public List<BrowseCategoryDto> browseCategories() {
        return categoryService.getBrowseCategories();
    }
    
    @GetMapping("/{slug}")
    public ResponseEntity<CategoryDetailsDto> getCategory(
            @PathVariable String slug) {

        CategoryDetailsDto response =
                categoryService.getCategoryDetails(slug);

        return ResponseEntity.ok(response);
    }

}

