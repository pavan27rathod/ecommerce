package com.ecommerce.cart_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @GetMapping("/start")
    public String start(){
        return "Cart Service Started...";
    }

    
}
