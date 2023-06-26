package com.example.supermarket.services;

import com.example.supermarket.models.ProductModel;
import com.example.supermarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    ProductRepository productRepository;

    public List<ProductModel> getAllProducts(){ return productRepository.findAll(); }

    public ProductModel getProductById(Long id){ return productRepository.findById(id).get(); }

    public String createProduct(ProductModel product){
        productRepository.save(product);
        return "Product saved";
    }

}
