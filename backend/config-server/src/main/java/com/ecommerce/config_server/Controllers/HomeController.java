package com.ecommerce.config_server.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/home")
	public String navigateToHome() {
		return "Config Server Started";
	}
}
