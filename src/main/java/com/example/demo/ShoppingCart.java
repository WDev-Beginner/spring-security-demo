package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS, value="session")
public class ShoppingCart {
    private List<String> cartItems;

    public ShoppingCart(){
        this.cartItems = new ArrayList<>();
        System.out.println("shopping cart created!");
    }

    public ShoppingCart(List<String> existingShoppingCart){
        this.cartItems = existingShoppingCart;
    }

    public void addItemToCart(String item){
        this.cartItems.add(item);
    }

    public void removeItemFromCart(String item){
        this.cartItems.remove(item);
    }

    public List<String> getCartItems() {
        return cartItems;
    }
}
