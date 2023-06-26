package com.example.supermarket.controllers;

import com.example.supermarket.models.QuantityModel;
import com.example.supermarket.payload.response.MessageResponse;
import com.example.supermarket.services.QuantityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quantities")
public class QuantityController {

    @Autowired
    QuantityServices quantityServices;

    @PostMapping("/")
    public ResponseEntity<?> createQuantity(@RequestBody QuantityModel quantityModel){
        quantityServices.createQuantity(quantityModel);
        return ResponseEntity.ok().body(new MessageResponse("Quantity created"));
    }

    @GetMapping("/")
    public List<QuantityModel> allQuantities(){
        return quantityServices.getAllQuantities();
    }
}
