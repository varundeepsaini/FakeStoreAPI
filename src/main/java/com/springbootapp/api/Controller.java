package com.springbootapp.api;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@RestController
public class Controller {

    @GetMapping(value = "/getAllCarts")
    public ArrayList<Cart> getAllCarts() {
        String url = "https://fakestoreapi.com/carts";
        RestTemplate rt = new RestTemplate();
        return new ArrayList<Cart>(Arrays.asList(Objects.requireNonNull(rt.getForObject(url, Cart[].class))));
    }

    @GetMapping(value = "/getCart")
    public Cart getCart() {
        String url = "https://fakestoreapi.com/carts/5";
        RestTemplate rt = new RestTemplate();
        return rt.getForObject(url, Cart.class);
    }

    @GetMapping(value = "/getInRange/{start}/{end}")
    public ArrayList<Cart> getInRange(@PathVariable String start, @PathVariable String end) {
        String url = "https://fakestoreapi.com/carts?startdate=" + start + "&enddate=" + end;
        RestTemplate rt = new RestTemplate();
        return new ArrayList<>(Arrays.asList(Objects.requireNonNull(rt.getForObject(url, Cart[].class))));
    }

    // delete a cart
    @GetMapping(value = "/deleteCart")
    public Cart deleteCart() {
        String url = "https://fakestoreapi.com/carts/6";
        RestTemplate rt = new RestTemplate();
        rt.delete(url);
        return rt.getForObject(url, Cart.class);
    }

    @GetMapping(value = "/getCartByUser/{id}")
    public ArrayList<Cart> getCartByUser(@PathVariable String id) {
        String url = "https://fakestoreapi.com/carts/user/" + id;
        RestTemplate rt = new RestTemplate();
        return new ArrayList<>(Arrays.asList(Objects.requireNonNull(rt.getForObject(url, Cart[].class))));
    }


    // create a post endpoint to add a new cart with the information given by the user
    @PostMapping(value = "/createCart")
    public Cart createCart(@RequestBody Cart cart) {
        String url = "https://fakestoreapi.com/carts";
        RestTemplate rt = new RestTemplate();
        return rt.postForObject(url, cart, Cart.class);
    }





}
