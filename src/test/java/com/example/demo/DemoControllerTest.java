package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemoControllerTest {
    @Test
    public void shouldStoreProduct(){
        DemoController testController =  new DemoController(new ShoppingCart(), null);

        testController.addToCart("butter");

        List<String> cart = testController.cart();

        assertEquals(List.of("butter"), cart);
    }

}