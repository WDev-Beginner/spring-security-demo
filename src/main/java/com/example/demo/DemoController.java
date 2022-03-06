package com.example.demo;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class DemoController {

    private final Random random = new Random();
    private final Map<String, Map<String, Object>> sessions = new HashMap<>();

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

        // create a cookie
        String sessionID = "" + random.nextInt();
        Cookie cookie = new Cookie("super_secret_something", sessionID);
        sessions.put(sessionID, new HashMap<>());

        //add cookie to response
        response.addCookie(cookie);
        return "Welcome to our secret page!";
    }


    @GetMapping("/addtocart")
    public String secret(String product, @CookieValue("super_secret_something") String id) {

        Map<String, Object> session = sessions.get(id);

        List<String> userProducts = (List<String>) session.getOrDefault("products", new ArrayList<>());
        userProducts.add(product);
        session.put("products", userProducts);


        return "Thank you for you purchase! You bought: " + product;
    }

    @GetMapping("/cart")
    public List<String> cart(@CookieValue("super_secret_something") String id) {
        return (List<String>) sessions.get(id).get("products");
    }

}
