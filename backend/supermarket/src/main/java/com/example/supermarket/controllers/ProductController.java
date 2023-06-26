package com.example.supermarket.controllers;

import com.example.supermarket.models.ProductModel;
import com.example.supermarket.payload.response.MessageResponse;
import com.example.supermarket.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductServices productServices;

    @GetMapping("/")
    public List<ProductModel> getAllProducts(){
        return  productServices.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductModel getProduct(@PathVariable("id") Long id){
        return productServices.getProductById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody ProductModel product){
        productServices.createProduct(product);
        return ResponseEntity.ok(new MessageResponse("Product created"));
    }
}
