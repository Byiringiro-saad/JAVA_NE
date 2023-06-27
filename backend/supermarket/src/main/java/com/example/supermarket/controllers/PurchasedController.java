package com.example.supermarket.controllers;

import com.example.supermarket.models.CartModel;
import com.example.supermarket.models.PurchasedModel;
import com.example.supermarket.payload.response.MessageResponse;
import com.example.supermarket.services.PurchasedServices;
import com.example.supermarket.services.QuantityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchased")
public class PurchasedController {
    @Autowired
    PurchasedServices purchasedServices;

    @Autowired
    QuantityServices quantityServices;

    @GetMapping("/{id}")
    public List<PurchasedModel> getPurchased(@PathVariable("id") Long useId){
        return purchasedServices.getAllPurchased(useId);
    }

    @GetMapping("/")
    public List<PurchasedModel> getAllPurchases(){
        return purchasedServices.getAllPurchases();
    }

    @PostMapping("/")
    public ResponseEntity<?> createPurchase(@RequestBody List<CartModel> cartModels){
        //create purchased models
        cartModels.forEach(item -> {
            purchasedServices.createPurchased(item);
        });

        return ResponseEntity.ok().body(new MessageResponse("Items purchased"));
    }
}
