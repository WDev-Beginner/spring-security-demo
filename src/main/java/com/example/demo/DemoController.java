package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    private final List<String> products = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "Welcome home!";
    }

    @GetMapping("/public")
    public String publicUrl() {
        return "Hello everyone!";
    }

    @GetMapping("/secret")
    public String secret() {
        return "Welcome to our secret page!";
    }

    @GetMapping("/addtocart")
    public String secret(String product) {
        products.add(product);
        System.out.println("You are adding product: " + product);
        return "Welcome to our secret page!";
    }

    @GetMapping("/cart")
    public List<String> cart() {
        return products;
    }

}
