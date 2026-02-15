package com.ecommerce.catalog_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// URL will be replaced later when inventory-service is created
@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryClient {

    @GetMapping("/api/inventory/{productId}")
    Integer getStockByProductId(@PathVariable("productId") String productId);

}
