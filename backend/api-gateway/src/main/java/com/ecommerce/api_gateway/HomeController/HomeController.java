package com.ecommerce.api_gateway.HomeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String navigateHome() {
		return "API Gateway initiated...";
	}
}
