package com.ecommerce.service_discovery.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String navigateHome() {
		return "Service Discovery initiated...";
	}

}
