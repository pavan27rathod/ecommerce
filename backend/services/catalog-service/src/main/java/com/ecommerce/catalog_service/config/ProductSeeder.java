package com.ecommerce.catalog_service.config;

import com.ecommerce.catalog_service.entity.Category;
import com.ecommerce.catalog_service.entity.Product;
import com.ecommerce.catalog_service.repository.CategoryRepository;
import com.ecommerce.catalog_service.repository.ProductRepository;

import net.datafaker.Faker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Configuration
public class ProductSeeder {

    @Bean
    CommandLineRunner seedProducts(
            ProductRepository productRepository,
            CategoryRepository categoryRepository
    ) {

        return args -> {

            if (productRepository.count() > 0) {
                System.out.println("Products already seeded");
                return;
            }

            Faker faker = new Faker();

            List<Category> categories =
                    categoryRepository.findByIsActiveTrueOrderByDisplayOrderAsc();

            int PRODUCTS_PER_CATEGORY = 500;

            for (Category category : categories) {

                for (int i = 0; i < PRODUCTS_PER_CATEGORY; i++) {

                    Product product = new Product();

                    String name =
                            category.getName()
                            + " "
                            + faker.number().numberBetween(100, 9999);


                    product.setName(name);

                    product.setSlug(
                            name.toLowerCase().replace(" ", "-")
                            + "-" + faker.number().digits(5)
                    );

                    product.setManufacturer(
                            faker.company().name()
                    );

                    product.setManufacturerPartNumber(
                            faker.bothify("MPN-#####")
                    );

                    product.setDescription(
                            faker.lorem().sentence(15)
                    );

                    product.setPrice(
                            BigDecimal.valueOf(
                                    faker.number().numberBetween(100, 50000)
                            )
                    );

                    product.setStockQuantity(
                            faker.number().numberBetween(0, 5000)
                    );

                    product.setCategoryId(category.getId());

                    product.setImageUrl(
                            "https://placehold.co/600x400"
                    );

                    product.setIsActive(true);

                    product.setCreatedAt(Instant.now());
                    product.setUpdatedAt(Instant.now());

                    productRepository.save(product);
                }

                System.out.println("Seeded products for category: " + category.getName());
            }

            System.out.println("Product seeding completed");
        };
    }
}
