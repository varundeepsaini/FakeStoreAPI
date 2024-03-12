package com.springbootapp.api;

import com.sun.jdi.ArrayReference;
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

    @GetMapping(value = "/getCartByUser/{id}")
    public ArrayList<Cart> getCartByUser(@PathVariable String id) {
        String url = "https://fakestoreapi.com/carts/user/" + id;
        RestTemplate rt = new RestTemplate();
        return new ArrayList<>(Arrays.asList(Objects.requireNonNull(rt.getForObject(url, Cart[].class))));
    }

    @PostMapping(value = "/createCart")
    public Cart createCart(@RequestBody Cart cart) {
        String url = "https://fakestoreapi.com/carts";
        RestTemplate rt = new RestTemplate();
        return rt.postForObject(url, cart, Cart.class);
    }

    @DeleteMapping(value = "/deleteCart/{id}")
    public Cart deleteCart(@PathVariable String id) {
        String url = "https://fakestoreapi.com/carts/" +id;
        RestTemplate rt = new RestTemplate();
        rt.delete(url);
        return rt.getForObject(url, Cart.class);
    }

    @PutMapping(value = "/updateCart/{id}")
    public void updateCart(@PathVariable String id, @RequestBody Cart cart) {
        String url = "https://fakestoreapi.com/carts/" + id;
        RestTemplate rt = new RestTemplate();
        rt.put(url, cart.toString());
    }


}
