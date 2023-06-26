package com.example.supermarket.controllers;

import com.example.supermarket.models.CartModel;
import com.example.supermarket.payload.response.MessageResponse;
import com.example.supermarket.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartServices cartServices;

    @GetMapping("/{id}")
    public List<CartModel> getCart(@PathVariable("id") Long useId){
        return cartServices.getCart(useId);
    }

    @PostMapping("/")
    public ResponseEntity<?> addToCart(@RequestBody CartModel cartModel){
        cartServices.createCart(cartModel);
        return ResponseEntity.ok().body(new MessageResponse("Item added to cart"));
    }
}
