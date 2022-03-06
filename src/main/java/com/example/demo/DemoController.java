package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class DemoController {


    private final ShoppingCart sessionShoppingCart;

    public DemoController(ShoppingCart sessionShoppingCart) {
        this.sessionShoppingCart = sessionShoppingCart;
        System.out.println("Controller CREATED!");
    }

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


    @GetMapping("/login")
    public String login(HttpServletResponse response) {
        return "Welcome to our secret page!";
    }


    @GetMapping("/addtocart")
    public String addToCart(String product) {
        this.sessionShoppingCart.addItemToCart(product);
        return "Thank you for you purchase! You bought:" + product;
    }

    @GetMapping("/cart")
    public List<String> cart() {
        return this.sessionShoppingCart.getCartItems();
    }

}
