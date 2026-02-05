package com.ecommerce.catalog_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeCatalog {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Catalog Service";
	}
}
